package com.blizi.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("editor")
    public String toEditor(){
        return "editor";
    }


    @RequestMapping("show")
    public String toShowPage(){
        return "showPage";
    }

    @RequestMapping("index")
    public String toIndex(){
        return "self_index";
    }

    @RequestMapping("loginPage")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping("login")
    public String toLogin2Page(){
        return "login2";
    }
}
