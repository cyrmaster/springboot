package com.cyr.springboot.Controller;

import com.cyr.springboot.bean.MqMessage;
import com.cyr.springboot.demo.AutoConfigurationTest.Author;
import com.cyr.springboot.demo.AutoConfigurationTest.AutorService;
import com.cyr.springboot.demo.WebSocket.CyrMessage;
import com.cyr.springboot.demo.WebSocket.MessageResponse;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TestController {
    @Autowired
    private Author author;

    @Autowired
    private AutorService autorService;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /*@RequestMapping("/login")
    public String login()
    {
        return  "login";
    }*/

    @ApiOperation(value = "showAuthor",notes = "类型安全的Bean关联配置文件")
    @RequestMapping(value = "/showAuthor",method = RequestMethod.GET)
    public String showAuthor()
    {
        return "authorName="+author.getName ()+"\n"+"authorAge="+author.getAge ();
    }

    @ApiOperation(value = "自动配置测试",notes = "自动配置autorService")
    @RequestMapping(value = "/AutoConfigureTest",method = RequestMethod.GET)
    public String auToConfigure()
    {
        return  autorService.service ();
    }


   @ApiOperation (value = "ActiveMq测试",notes = "使用内嵌ActiveMq")
    @RequestMapping(value = "/SendMessage",method =RequestMethod.POST)
    public void sendMessage(@RequestBody MqMessage mqMessage)
   {

   }


}
