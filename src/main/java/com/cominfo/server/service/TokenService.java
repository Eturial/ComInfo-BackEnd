package com.cominfo.server.service;

import com.cominfo.server.pojo.User;

public interface TokenService {
    String getToken(User user);
}
