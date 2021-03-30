package com.cominfo.server.controller;


import com.alibaba.fastjson.JSONObject;
import com.cominfo.server.pojo.ReqUserLogin;
import com.cominfo.server.pojo.RespBean;
import com.cominfo.server.pojo.User;
import com.cominfo.server.service.LoginService;
import com.cominfo.server.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@Api
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService service;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/check")
    @ApiResponse(code = 200, message = "登录确认")
    @ApiOperation(value = "验证用户登录信息", produces = "application/json", httpMethod = "POST")
    @ApiImplicitParam(paramType = "ReqUserLogin", name = "user")
    public RespBean isLogin(@RequestBody ReqUserLogin reqUserLogin) {
        JSONObject object = new JSONObject();
        User user = service.getUserByStuNo(reqUserLogin.getStuNo());
        if (user == null) {
            return RespBean.error("用户不存在", null);
        } else {
            if (!user.getPassword().equals(reqUserLogin.getPassword())) {
                return RespBean.error("密码错误", null);
            } else {
                String token = tokenService.getToken(user);
                object.put("token", token);
                return RespBean.success("登陆成功", object);
            }
        }


//        object.put("message", "login failed.");
//        object.put("status", 500);
//        object.put("token", tokenService.getToken());
//        return object;
//        return service.login(user);
    }


//    @UserLoginToken
//    @RequestMapping("/getusernumber")
//    @ResponseBody
//    public Object getToken(@RequestHeader("token") String token) {
//        //User user = object.getObject("user", User.class);
////        String token = object.getString("token");
//        int stuNumber = Integer.parseInt(JWT.decode(token).getAudience().get(0));
//        //System.out.println(stuNumber);
//        ReqUserLogin user = new ReqUserLogin();
//        user.setStuNumber(stuNumber);
//        User userDatabase = service.getUserById(user.getStuNumber());
//        String generateToken = tokenService.getToken(userDatabase);
//
//
//        return generateToken.equals(token);
//    }
}
