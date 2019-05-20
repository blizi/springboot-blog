package com.blizi.blog.controller;

import com.blizi.blog.entity.User;
import com.blizi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.date.DateUtils;
import utils.date.utils.stati_info.Number;
import utils.session.SessionUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class LoginController {
    @Autowired
    private UserService service;

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody User user, HttpServletRequest request){
        System.out.println("==================="+user.getName());
        User u = service.selectUserByUserName(user.getName());
        if(null!=u){
            if(user.getPassword().equals(u.getPassword())){
                new SessionUtils().updateSession(request,u);
                return Number.LOGIN_SUCCESS;
            }
        }
        return Number.LOGIN_FAILED;
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(@RequestBody User user){
        System.out.println(user.toString());
        user.setReDate(DateUtils.getNowTime());
        if(service.selectUserByUserName(user.getName())!=null){
            return Number.ADD_FAILED;
        }
        try {
            service.addUser(user);
        }catch (Exception e){
            return Number.ADD_FAILED;
        }
        return Number.ADD_SUCCESS;
    }

}
