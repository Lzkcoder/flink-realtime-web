package com.atguigu.flinkrealtimeweb.controller;


import com.atguigu.flinkrealtimeweb.service.TTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/tt")
public class ttController {

    @Autowired
    TTService ttService;

    @RequestMapping("/word")
    public String getWord(@RequestParam(value = "word",required = false)String s){
        String words = ttService.getWords(s);
        return words+s;
    }
}
