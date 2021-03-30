package com.cominfo.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.cominfo.server.config.jwt.UserLoginToken;
import com.cominfo.server.pojo.User;
import com.cominfo.server.service.ProfileService;
import com.cominfo.server.service.impl.TokenServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
//        int stuNumber = Integer.parseInt(JWT.decode(token).getAudience().get(0));
        return service.getUser(TokenServiceImpl.getStuNumber(token));
    }


    @PostMapping(value = "/updateUser")
    @ResponseBody
    @UserLoginToken
//    @PassToken
    public boolean updateUser(@RequestHeader("Authorization") String token, @RequestBody JSONObject object) {
        User user = new User();
        user.setPassword(object.getString("password"));
        user.setName(object.getString("name"));
        user.setAccount(object.getString("account"));
        user.setSchool(object.getString("school"));
        user.setGender(object.getString("gender"));
        user.setStuNo(TokenServiceImpl.getStuNumber(token));

        return service.updateUser(user) == 1;
    }


//    @GetMapping("/mycommunity")
//    @ResponseBody
//    public List<Community> getCommunities(@RequestHeader("token") String token) {
//        int stuNumber = Integer.parseInt(JWT.decode(token).getAudience().get(0));
//        return service.getCommunities(stuNumber);
//    }


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
