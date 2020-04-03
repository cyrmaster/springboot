package com.cyr.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Html")
public class TestController {

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
}
