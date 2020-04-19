package com.cyr.springboot.demo.WebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker   //注解开启使用STOMP协议来传输给予代理（message broker)的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {//注册STOMP协议的节点，并映射制定的url
        registry.addEndpoint("/endpointCyr").withSockJS(); //注册一个STOMP的endpoint,并指定使用SockJS协议
        registry.addEndpoint("/endpointChat").withSockJS();//注册一个名为/endpointChat的endpoint
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理模式
        super.configureMessageBroker(registry);
        registry.enableSimpleBroker("/topic");//广播式
        registry.enableSimpleBroker("/queue","/topic");//对点对式增加一个/queue消息代理
    }


}
