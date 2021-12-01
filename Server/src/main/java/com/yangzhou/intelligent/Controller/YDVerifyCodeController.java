package com.yangzhou.intelligent.Controller;

import com.yangzhou.intelligent.Service.YDVerifyCodeService;
import com.yangzhou.intelligent.model.YDVerifyCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/YDVerifyCode")
public class YDVerifyCodeController {
    @Autowired
    private YDVerifyCodeService ydVerifyCodeService;

    @ResponseBody
    @RequestMapping(value = "/insertSelective",method = RequestMethod.POST)
    @ApiOperation(value = "插入验证码记录")
    public int insertSelective(YDVerifyCode record){
        return ydVerifyCodeService.insertSelective(record);
    }

    @ResponseBody
    @RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
    @ApiOperation(value = "修改验证记录")
    public  int updateByPrimaryKeySelective(YDVerifyCode record){
        return ydVerifyCodeService.updateByPrimaryKeySelective(record);
    }

}
