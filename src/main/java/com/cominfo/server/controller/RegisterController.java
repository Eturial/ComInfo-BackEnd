package com.cominfo.server.controller;

import com.cominfo.server.pojo.ReqUserRegister;
import com.cominfo.server.pojo.RespBean;
import com.cominfo.server.service.RegisterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/register")
@Api
@CrossOrigin
public class RegisterController {
    @Autowired
    private RegisterService service;
//    private int mailCode;

    @PostMapping("/verifyuser")
    @ApiOperation(value = "获取用户学号 密码", produces = "application/json", httpMethod = "POST")
    @ApiImplicitParam(paramType = "ReqUserRegister", name = "user")
    @ApiResponse(code = 200, message = "注册确认")
    public RespBean verifyUser(@RequestBody ReqUserRegister user) {
        System.out.println(user.toString());
        if (service.isNewUser(user)) {
            if(Objects.equals(user.getPassword(), user.getPrePass())) {
                return RespBean.success("注册成功");
            } else{
                return RespBean.error("两次输入密码不一致");
            }
        } else {
            return RespBean.error("该用户已存在");
        }
    }

//    @PostMapping(value = "/verifycode", produces = "application/json;charset=utf-8")
//    @ResponseBody
//    @ApiOperation(value = "发送验证码", produces = "application/json", httpMethod = "POST")
//    @ApiImplicitParam(paramType = "String", name = "mailbox")
//    @ApiResponse(code = 200,message = "验证码发送")
//    public int sendMail(@RequestBody ReqUserRegister user) {
//
//        return service.sendMail(user.getMailbox());
//    }


    @GetMapping("/getUser")
    public String getUser() {
        return "success";
    }

}

