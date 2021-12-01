package com.yangzhou.intelligent.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yangzhou.intelligent.Service.EmailService;
import com.yangzhou.intelligent.Service.YDVerifyCodeService;
import com.yangzhou.intelligent.annotation.ResponseResult;
import com.yangzhou.intelligent.model.YDVerifyCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.yangzhou.intelligent.utils.VerCodeGenerateUtil.generateVerCode;

@Controller
@ResponseResult  // 统一返回格式
@CrossOrigin
public class EmailController {
    @Autowired
    EmailService emailService;

    @Autowired
    private YDVerifyCodeService ydVerifyCodeService;

    @ResponseBody
    @RequestMapping(value = "/email",method = RequestMethod.POST)
    @ApiOperation(value = "发送有邮件")
    public Object sendEmail(String emailAddress) {
        JSONObject jsonObject = new JSONObject();
        try {
            String code = generateVerCode();
            emailService.sendEmailVerCode(emailAddress,code);
            YDVerifyCode ydVerifyCode = new YDVerifyCode();
            ydVerifyCode.setEmailNumber(emailAddress);
            ydVerifyCode.setVerifyCodeNumber(code);
            ydVerifyCode.setIfverify(0);
            Date date = new Date();
            ydVerifyCode.setDate(date);
            ydVerifyCodeService.insertSelective(ydVerifyCode);
            jsonObject.put("message", "邮件发送成功");
            return jsonObject;
        } catch (Exception e) {
            jsonObject.put("message", "邮件发送成功");
            return jsonObject;
        }

    }
}
