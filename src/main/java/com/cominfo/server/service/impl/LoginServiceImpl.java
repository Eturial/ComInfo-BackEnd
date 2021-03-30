package com.cominfo.server.service.impl;

import com.cominfo.server.mapper.UserMapper;
import com.cominfo.server.pojo.ReqUserLogin;
import com.cominfo.server.pojo.User;
import com.cominfo.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper loginMapper;

//    @Override
//    public boolean login(ReqUserLogin user) {
//        User one = loginMapper.getUserByPassword(user);
//        return one != null;
//    }

    @Override
    public User getUserByStuNo(String stuNo) {
        return loginMapper.getUserByStuNo(stuNo);
    }
}
