package com.yangzhou.intelligent.Service;

import com.yangzhou.intelligent.model.YDVerifyCode;

public interface YDVerifyCodeService {
    int insertSelective(YDVerifyCode record);

    int updateByPrimaryKeySelective(YDVerifyCode record);

    YDVerifyCode selectByEmailAndCode(String userEmail,String verifyCodeNumber);

    int updateState(String userEmail,String verifyCodeNumber);
}
