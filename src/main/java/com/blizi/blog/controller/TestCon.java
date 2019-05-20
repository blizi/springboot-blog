package com.blizi.blog.controller;

import com.blizi.blog.entity.User;
import com.blizi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestCon {

    @Autowired()
    private UserService service;

    @RequestMapping("allUser")
    public List<User> allUserInfo(){
        return service.selectAll();
    }

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
