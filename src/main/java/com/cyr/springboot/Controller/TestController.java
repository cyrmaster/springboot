package com.cyr.springboot.Controller;

import com.cyr.springboot.demo.AutoConfigurationTest.Author;
import com.cyr.springboot.demo.AutoConfigurationTest.AutorService;
import com.cyr.springboot.demo.WebSocket.CyrMessage;
import com.cyr.springboot.demo.WebSocket.MessageResponse;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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

    @ApiOperation(value = "webSokect测试",notes = "广播式topic")
    @MessageMapping("/welcome")//浏览器向服务端发送请求时，通过@MessaheMapping映射/welcome这个地址
    @SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了@SenTo中的路径的浏览器发送消息
      public MessageResponse say(CyrMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return  new MessageResponse("Welcome,"+message.getName()+"!");
    }


}
