package com.cominfo.server.service;

import com.cominfo.server.pojo.User;

public interface ProfileService {
    User getUser(String stuNo);

    int updateUser(User user);
}
