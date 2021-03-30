package com.cominfo.server.mapper;

import com.cominfo.server.pojo.ReqUserLogin;
import com.cominfo.server.pojo.ReqUserRegister;
import com.cominfo.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

//    User getUserByPassword(@Param("user") ReqUserLogin user);

    User getUserByStuNo(@Param("stuNo") String stuNo);

    void addOne(@Param("user") ReqUserRegister user);

    void updateUserGender(User user);

    void updateUserName(User user);

    void updateUserAccount(User user);

    void updateUserPassword(User user);
}
