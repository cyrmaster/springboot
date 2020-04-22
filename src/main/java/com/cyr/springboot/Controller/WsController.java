package com.cyr.springboot.Controller;

import com.cyr.springboot.demo.WebSocket.CyrMessage;
import com.cyr.springboot.demo.WebSocket.MessageResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;//通过SimpMessagingTemplate向浏览器发送消息

    @ApiOperation(value = "webSokect测试1",notes = "广播式topic")
    @MessageMapping("/welcome")//浏览器向服务端发送请求时，通过@MessaheMapping映射/welcome这个地址
    @SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了@SenTo中的路径的浏览器发送消息
    public MessageResponse say(CyrMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return  new MessageResponse("Welcome,"+message.getName()+"!");
    }

    @ApiOperation(value = "webSokect测试2",notes = "点对对式queue")
    @MessageMapping("/chat")
    public void handleChat(Principal principal,CyrMessage message)//SpringMVC中，可以直接在参数中获得principal，principle中包含当前用户的信息。
    {
        if(principal.getName().equals("cyr"))
        {
            simpMessagingTemplate.convertAndSendToUser("chenyr","/queue/notifications",principal.getName()+"---send:"+message.getName());
        }
        else
        {
            simpMessagingTemplate.convertAndSendToUser("cyr","/queue/notifications",principal.getName()+"---send:"+message.getName());
        }
    }
}
