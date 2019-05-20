package com.blizi.blog.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("content")
public class uploadFile {
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map editorMD(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile[] file) throws IOException {
        System.out.println("ewe");
        Map map = new HashMap();
        try {
            for (MultipartFile myfile : file) {
                if (myfile.isEmpty()) {
                    map.put("success",0);
                    return map;
                } else {
                    System.out.println("文件长度: " + myfile.getSize());
                    System.out.println("文件类型: " + myfile.getContentType());
                    System.out.println("文件名称: " + myfile.getName());
                    System.out.println("文件原名: " + myfile.getOriginalFilename());
                    System.out.println("========================================");

                  //  String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
                    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HHmmss");
                    String str =  sd.format(new Date());
                    String[] result = str.split(" ");
                    String realPath = "D:\\img\\"+result[0]+"\\"+result[1];
                    //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
                    FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));
                    map.put("success",1);
                    map.put("message","上传成功");
                    map.put("url","\\image\\"+result[0]+"\\"+result[1]+"\\"+myfile.getOriginalFilename());
                }
            }
        }catch (Exception e) {
            map.put("success",0);
        }
        return map;
    }
}