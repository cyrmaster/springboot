package com.cyr.springboot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TestController {

    @RequestMapping("/login")
    public String login()
    {
        return  "login";
    }
}
