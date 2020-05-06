package com.cyr.springboot.Dao.Redis;

import com.cyr.springboot.bean.Person;
import com.cyr.springboot.bean.Personredis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonRedisDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String ,String> valOpsStr;//使用@Resource注解指定stringRedisTemplate，可注入基于字符串的简单属性操作方法。

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOps;//使用@Resource注解指定redisTemplate，可注入基于对象的简单属性操作方法

    public void stringRedisTemplateDemo()//通过set方法，存储字符串类型
    {
        valOpsStr.set("xx","uu");
    }
    public void save(Personredis personredis)
    {
        valOps.set(personredis.getId(),personredis);
    }
    public String getString()
    {
        return  valOpsStr.get("xx");
    }
    public Person getPerson()
    {
        return (Person)valOps.get("1");
    }
}
