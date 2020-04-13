package com.cyr.springboot.Controller;

import com.cyr.springboot.bean.Author;
import com.cyr.springboot.demo.AutoConfigurationTest.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TestController {
    @Autowired
    private Author author;

    @Autowired
    private AutorService autorService;

    @RequestMapping("/login")
    public String login()
    {
        return  "login";
    }
    @RequestMapping("ajaxtest")
    public String ajaxtest()
    {
        return "ajaxtest";
    }

    @RequestMapping("/showAuthor")
    public String showAuthor()
    {
        return "authorName="+author.getName ()+"\n"+"authorAge="+author.getAge ();
    }
    @RequestMapping("/AutoConfigureTest")
    public String auToConfigure()
    {
        return  autorService.service ();
    }

}
