package com.blizi.blog.controller;

import com.blizi.blog.entity.Markdown;
import com.blizi.blog.entity.User;
import com.blizi.blog.service.ContentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.date.DateUtils;
import utils.date.utils.stati_info.Number;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService service;

    @RequestMapping("/content")
    public String getContentMarkDownById(int id, Model model){
//        System.out.println(id);
//        return  service.getMarkDownById(id).getContent();
        model.addAttribute("content",service.getMarkDownById(id).getContent());
        model.addAttribute("title",service.getMarkDownById(id).getTitle());
        model.addAttribute("date" ,service.getMarkDownById(id).getDate());
        return "showPage";
    }

    @RequestMapping("/session")
    @ResponseBody
    public User getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            user.setPassword("和平民主自由富强");
        }
        return user;
    }

    @ResponseBody
    @RequestMapping("page")
    public List<Markdown> page(@RequestParam("pageNum") int pageNum, int pageSize){
        //System.out.println(pageNum+"  "+pageSize);
        List<Markdown> list = new ArrayList();
      //  pageNum--;
        System.out.println(pageNum);
       PageInfo<Markdown> info = service.page(pageNum,pageSize);
       for(Markdown markdown:info.getList()){
           try {
               markdown.setContent(markdown.getContent().substring(0,50)+"......");
           }catch (Exception e){
               markdown.setContent(markdown.getContent()+"......");
           }
           list.add(markdown);
       }
        return list;
    }
    @ResponseBody
    @RequestMapping("add")
    public String addContent(HttpServletRequest request,@RequestBody Markdown markdown){
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            markdown.setDate(DateUtils.getNowTime());
            markdown.setUid(user.getId());
            service.addContent(markdown);
            return Number.ADD_SUCCESS;
        }catch (Exception e){
            return Number.ADD_FAILED;
        }
    }
}
