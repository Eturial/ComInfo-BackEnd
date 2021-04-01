package com.cominfo.server.service;

import com.cominfo.server.pojo.RespBean;
import com.cominfo.server.pojo.User;

import java.util.List;

public interface ProfileService {
    User getUser(String stuNo);

    RespBean updateUser(User user);

    List<String> getUserSchoolmates(String school);
}
