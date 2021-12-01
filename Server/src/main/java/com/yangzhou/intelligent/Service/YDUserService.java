package com.yangzhou.intelligent.Service;

import com.yangzhou.intelligent.model.YDUser;

public interface YDUserService {
    int insertSelective(YDUser record);

    YDUser loginVerify(String userAccount, String userPassword);

    YDUser selectByPrimaryKey(String userId);

    YDUser selectByAccountid(String userAccount);

    YDUser selectByEmailid(String userEmail);
}
