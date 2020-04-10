package com.cyr.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "author")
//类型安全的Bean关联配置文件
public class Author {
    private String name;
    private Long age;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Long getAge () {
        return age;
    }

    public void setAge (Long age) {
        this.age = age;
    }
}
