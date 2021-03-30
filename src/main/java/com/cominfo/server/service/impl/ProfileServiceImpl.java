package com.cominfo.server.service.impl;

import com.cominfo.server.mapper.UserMapper;
import com.cominfo.server.pojo.User;
import com.cominfo.server.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(String stuNo) {
        //        user.getDateString();
        return userMapper.getUserByStuNo(stuNo);
    }

    @Override
    public int updateUser(User user) {
        // 获取当前user对象 用于密码检验
        User checkPassword = userMapper.getUserByStuNo(user.getStuNo());

        if (user.getGender() != null) {
            userMapper.updateUserGender(user);
        }
        if (user.getName() != null) {
            userMapper.updateUserName(user);
        }
        if (user.getAccount() != null) {
            userMapper.updateUserAccount(user);
        }
        if (user.getPassword() != null && !checkPassword.getPassword().equals(user.getPassword())) {
            userMapper.updateUserPassword(user);
        } else if (checkPassword.getPassword().equals(user.getPassword())){
            return 0;
        }
        return 1;
    }

//    @Override
//    public List<Community> getCommunities(int stuNumber) {
//        return communityDao.getCommunities(stuNumber);
//    }

//    @Override
//    public boolean createCommunity(Community community) {
//        return false;
//    }

//    @Override
//    public List<Activity> getActivities(User user) {
//        return null;
//    }

//    @Override
//    public List<User> getUsers(User user) {
//        return null;
//    }
}
