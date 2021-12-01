package com.yangzhou.intelligent.mapper;

import com.yangzhou.intelligent.model.YDUser;

public interface YDUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(YDUser record);

    int insertSelective(YDUser record);

    YDUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(YDUser record);

    int updateByPrimaryKey(YDUser record);

    YDUser loginVerify(String userAccount,String userPassword);

    YDUser selectByAccountid(String userAccount);

    YDUser selectByEmailid(String userEmail);
}