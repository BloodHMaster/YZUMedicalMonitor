package com.yangzhou.intelligent.mapper;

import com.yangzhou.intelligent.model.YDVerifyCode;

public interface YDVerifyCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YDVerifyCode record);

    int insertSelective(YDVerifyCode record);

    YDVerifyCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YDVerifyCode record);

    int updateByPrimaryKey(YDVerifyCode record);

    YDVerifyCode selectByEmailAndCode(String userEmail,String verifyCodeNumber);

    int updateState(String userEmail,String verifyCodeNumber);
}