package com.yangzhou.intelligent.Controller;


import com.yangzhou.intelligent.Config.UserLoginToken;
import com.yangzhou.intelligent.Service.YDUserService;
import com.yangzhou.intelligent.Service.YDVerifyCodeService;
import com.yangzhou.intelligent.annotation.ResponseResult;
import com.yangzhou.intelligent.model.UserInfo;
import com.yangzhou.intelligent.model.UserRegist;
import com.yangzhou.intelligent.model.YDVerifyCode;
import com.yangzhou.intelligent.pojo.BizException;
import com.yangzhou.intelligent.utils.GetUserToken;
import com.yangzhou.intelligent.utils.Md5Utils;
import io.swagger.annotations.ApiOperation;
import com.yangzhou.intelligent.model.YDUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
/***
 * YDUser控制器
 * @Title: YDUserController.java
 * @author Mr. sun
 * @date 2021年4月28日
 * @version V1.0
 */
@Controller
@CrossOrigin
@ResponseResult  // 统一返回格式
@RequestMapping(value = "/YDUser")
public class YDUserController {
    @Autowired
    private YDUserService ydUserService;

    @Autowired
    private YDVerifyCodeService ydVerifyCodeService;

    /**
     * 用户注册逻辑，如果账号已存在，返回错误信息，如果邮箱已经使用，返回错误信息，如果验证码不存在返回错误信息，如果
     */
    @ResponseBody
    @RequestMapping(value = "/insertSelective",method = RequestMethod.POST)
    @ApiOperation(value = "用户注册")
    public    int insertSelective(UserRegist userRegist){
        String userAccount = userRegist.getUserAccount();
        String userEmail = userRegist.getUserEmail();
        System.out.println(userRegist.toString());
        if (ydUserService.selectByAccountid(userAccount)!=null){
            throw new BizException("用户账户已存在");
        }else if(ydUserService.selectByEmailid(userEmail) !=null){
            throw new BizException("用户邮箱已占有");
        }else{
            String verifyCodeNumber = userRegist.getVerifycode();
            YDVerifyCode ydVerifyCode = ydVerifyCodeService.selectByEmailAndCode(userEmail,verifyCodeNumber);

            Date date = new Date();
            if(ydVerifyCode == null){
                throw new BizException("验证码错误，请重试");
            }else if((date.getTime()-ydVerifyCode.getDate().getTime())/(1000*60) >6){
                ydVerifyCodeService.updateState(userEmail,verifyCodeNumber);
                throw new BizException("验证码超时，请重试");
            }else {
                ydVerifyCodeService.updateState(userEmail,verifyCodeNumber);
                YDUser record = new YDUser();
                record.setUserId(UUID.randomUUID().toString());
                String password = Md5Utils.code(userRegist.getUserPassword());
                record.setUserPassword(password);
                record.setUserEmail(userEmail);
                record.setUserNickName(userAccount);
                record.setUserAccount(userAccount);
                Date registdate = new Date();
                record.setUserRegisterDate(registdate);
                return ydUserService.insertSelective(record);
            }

        }
    }

    @ResponseBody
    @UserLoginToken //需要登录才能使用
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户的昵称和头像")
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        String userid = GetUserToken.getTokenUserId();
        YDUser result = ydUserService.selectByPrimaryKey(userid);
        userInfo.setuser_nick_name(result.getUserNickName());
        userInfo.setuser_avatar(result.getUserAvatar());

        return userInfo;

    }

}
