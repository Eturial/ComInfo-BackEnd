package com.cominfo.server.service.impl;

import com.cominfo.server.mapper.UserMapper;
import com.cominfo.server.pojo.RespBean;
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
    public RespBean updateUser(User user) {
        // 获取当前user对象 用于密码检验
        User checkPassword = userMapper.getUserByStuNo(user.getStuNo());

        if (user.getGender() != null) {
            userMapper.updateUserGender(user);
        }
        if (user.getName() != null) {
            userMapper.updateUserName(user);
        }
        if (user.getAccount() != null) {
            try{
                userMapper.updateUserAccount(user);
            } catch (Exception e) {
                Throwable cause = e.getCause();
                if(cause instanceof java.sql.SQLIntegrityConstraintViolationException) {
                    return RespBean.error("该用户已存在");
                }
            }
        }

        if(user.getSchool() != null) {
            userMapper.updateUserSchool(user);
        }
        if (user.getPassword() != null && !checkPassword.getPassword().equals(user.getPassword())) {
            userMapper.updateUserPassword(user);
        } else if (checkPassword.getPassword().equals(user.getPassword())){
            return RespBean.error("新密码与原密码不能相同");
        }
        return RespBean.success("操作成功");
    }

    @Override
    public List<String> getUserSchoolmates(String school) {
        return userMapper.getUserSchoolmates(school);
    }

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
