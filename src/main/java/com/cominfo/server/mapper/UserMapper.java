package com.cominfo.server.mapper;

import com.cominfo.server.pojo.ReqUserLogin;
import com.cominfo.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public class UserMapper {

    User getUserByPassword(@Param("user") ReqUserLogin user) {
        return null;
    }

    User getUserById(@Param("id") long id) {
        return null;
    }
}
