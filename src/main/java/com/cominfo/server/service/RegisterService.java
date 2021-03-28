package com.cominfo.server.service;

import com.cominfo.server.pojo.ReqUserRegister;

public interface RegisterService {
    boolean isNewUser(ReqUserRegister user);
}
