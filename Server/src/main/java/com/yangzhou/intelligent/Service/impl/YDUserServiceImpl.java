package com.yangzhou.intelligent.Service.impl;

import com.yangzhou.intelligent.Service.YDUserService;
import com.yangzhou.intelligent.mapper.YDUserMapper;
import com.yangzhou.intelligent.model.YDUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YDUserServiceImpl implements YDUserService {
    @Autowired
    private YDUserMapper ydUserMapper;

    @Override
    public int insertSelective(YDUser record){
        return ydUserMapper.insertSelective(record);
    }

    @Override
    public YDUser loginVerify(String userAccount,String userPassword){
        return ydUserMapper.loginVerify(userAccount,userPassword);
    }

    @Override
    public YDUser selectByPrimaryKey(String userId){
        return ydUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public  YDUser selectByAccountid(String userAccount){
        return ydUserMapper.selectByAccountid(userAccount);
    }

    @Override
    public  YDUser selectByEmailid(String userEmail){
        return ydUserMapper.selectByEmailid(userEmail);
    }
}
