package com.cominfo.server.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cominfo.server.pojo.User;
import com.cominfo.server.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(User user) {
        String token = "";
        //不能直接存密码
        //存储学号
        token = JWT.create().withAudience(user.getStuNo())
                .sign(Algorithm.HMAC256(user.getStuNo()));

            return token;
        }

        public static String getStuNumber(String token) {
            return JWT.decode(token).getAudience().get(0);
        }
}

