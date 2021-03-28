package com.cominfo.server.service;

import com.cominfo.server.pojo.ReqUserLogin;
import com.cominfo.server.pojo.User;

public interface LoginService {

//    boolean login(ReqUserLogin user);
    User getUserById(long userIdInt);

}
