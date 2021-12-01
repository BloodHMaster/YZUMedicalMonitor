package com.yangzhou.intelligent.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yangzhou.intelligent.Config.UserLoginToken;
import com.yangzhou.intelligent.Service.YDUserService;
import com.yangzhou.intelligent.annotation.ResponseResult;
import com.yangzhou.intelligent.model.YDUser;
import com.yangzhou.intelligent.pojo.BizException;
import com.yangzhou.intelligent.pojo.ResultCode;
import com.yangzhou.intelligent.utils.Md5Utils;
import com.yangzhou.intelligent.utils.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.yangzhou.intelligent.utils.GetUserToken.getRequest;

/***
 * login控制器
 * @Title: LoginController.java
 * @author Mr. sun
 * @date 2021年4月28日
 * @version V1.0
 */

@Controller
@CrossOrigin
@ResponseResult
public class LoginController {
    @Autowired
    private YDUserService ydUserService;
    @Autowired
    TokenUtil tokenUtil;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录操作")
    public Object login(String userAccount, String userPassword, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        YDUser result = ydUserService.selectByAccountid(userAccount);
        //1、查询登录账号的登录信息（查到/未查到）
        if (result == null) {
            throw new BizException("账号不存在");
        } else {
            //2、判断登录密码和库里面密码是否一致
            String pwd1 = Md5Utils.code(userPassword);
            if (pwd1.equals(result.getUserPassword())) {
                String token = tokenUtil.getToken(result);
                jsonObject.put("token", token);

                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                response.addCookie(cookie);
                return jsonObject;
            } else {
                throw new BizException("登录失败,密码错误");

            }
        }


    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/logout",method =RequestMethod.POST)
    @ApiOperation(value = "退出登录")
    public Object logout(){
        JSONObject jsonObject = new JSONObject();
        String token = getRequest().getHeader("Authorization");// 从 http 请求头中取出 token
//        去除session中的信息，这里暂时没写
        jsonObject.put("message", "退出登录");


        return jsonObject;
    }
}
