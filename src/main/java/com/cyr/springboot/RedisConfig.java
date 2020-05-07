package com.cyr.springboot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings({"rawtypes","unchecked"})
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException
    {
        RedisTemplate<Object,Object> template=new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om=new ObjectMapper();//将java对象转成jason
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);//设置任何属性可见
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);//包括上文提到的所有特征，而且包含即将被序列化的类里的全部、非final的属性，也就是相当于整个类、除final外的的属性信息都需要被序列化和反序列化
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);//设置value的序列化采用Jackson2JsonRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());//设置key的序列化采用StringRedisSerializer
        return template;
    }
}
