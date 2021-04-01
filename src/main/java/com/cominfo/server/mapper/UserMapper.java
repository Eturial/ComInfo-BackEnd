package com.cominfo.server.mapper;

import com.cominfo.server.pojo.ReqUserLogin;
import com.cominfo.server.pojo.ReqUserRegister;
import com.cominfo.server.pojo.School;
import com.cominfo.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

//    User getUserByPassword(@Param("user") ReqUserLogin user);

    User getUserByStuNo(@Param("stuNo") String stuNo);

    void addOne(@Param("user") ReqUserRegister user);

    //There is no getter for property named 'user' in 'class xxx'
    // 记得加注解 太艹了
    void updateUserGender(@Param("user") User user);

    void updateUserName(@Param("user") User user);

    void updateUserAccount(@Param("user") User user);

    void updateUserPassword(@Param("user") User user);

    void updateUserSchool(@Param("user") User user);

    List<String> getUserSchoolmates(@Param("school") String school);
}
