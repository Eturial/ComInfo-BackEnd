package com.cominfo.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.cominfo.server.config.jwt.UserLoginToken;
import com.cominfo.server.pojo.RespBean;
import com.cominfo.server.pojo.User;
import com.cominfo.server.service.ProfileService;
import com.cominfo.server.service.impl.TokenServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/profile")
@Api
@CrossOrigin
public class ProfileController {
    @Autowired
    ProfileService service;


    @GetMapping(value = "/getUser")
    @ResponseBody
    @UserLoginToken
    public User getUser(@RequestHeader("Authorization") String token) {
//        System.out.println(JWT.decode(token).getAudience().get(0));
        return service.getUser(TokenServiceImpl.getStuNumber(token));
    }


    @PostMapping(value = "/updateUser")
    @ResponseBody
    @UserLoginToken
//    @PassToken
    public RespBean updateUser(@RequestHeader("Authorization") String token, @RequestBody JSONObject object) {
        User user = new User();
        user.setPassword(object.getString("password"));
        user.setName(object.getString("name"));
        user.setAccount(object.getString("account"));
        user.setSchool(object.getString("school"));
        user.setGender(object.getString("gender"));
        user.setStuNo(TokenServiceImpl.getStuNumber(token));

        return service.updateUser(user);
    }


    @GetMapping("/mySchoolmates")
    @ResponseBody
    public List<String> getUserSchoolmates(@RequestHeader("token") String token) {
        User user = service.getUser(TokenServiceImpl.getStuNumber(token));
        String school = user.getSchool();
        return service.getUserSchoolmates(school);
    }


//    @RequestMapping(value = "/createcommunity", method = RequestMethod.POST)
//    @ResponseBody
//    public boolean createCommunity(Community community) {
//        return false;
//    }

//    @RequestMapping(value = "/myactivities", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Activity> getActivities(@RequestBody String username) {
//        return new ArrayList<>();
//    }

//    @RequestMapping(value = "/friends", method = RequestMethod.GET)
//    @ResponseBody
//    public ArrayList<String> getSchoolFriends(@RequestBody String account) {
//        return new ArrayList<String>();
//    }
}
