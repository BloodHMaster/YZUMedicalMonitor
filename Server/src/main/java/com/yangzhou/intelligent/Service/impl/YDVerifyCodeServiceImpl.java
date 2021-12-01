package com.yangzhou.intelligent.Service.impl;

import com.yangzhou.intelligent.Service.YDVerifyCodeService;
import com.yangzhou.intelligent.mapper.YDVerifyCodeMapper;
import com.yangzhou.intelligent.model.YDVerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YDVerifyCodeServiceImpl implements YDVerifyCodeService {
    @Autowired
    private YDVerifyCodeMapper ydVerifyCodeMapper;

    @Override
    public int insertSelective(YDVerifyCode record){
        return ydVerifyCodeMapper.insertSelective(record);
    }

    @Override
    public  int updateByPrimaryKeySelective(YDVerifyCode record){
        return ydVerifyCodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public     YDVerifyCode selectByEmailAndCode(String userEmail,String verifyCodeNumber){
        return ydVerifyCodeMapper.selectByEmailAndCode(userEmail,verifyCodeNumber);
    }
    @Override
    public   int updateState(String userEmail,String verifyCodeNumber){
        return ydVerifyCodeMapper.updateState(userEmail,verifyCodeNumber);
    }

}
