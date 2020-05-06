package com.cyr.springboot.bean;

import io.swagger.models.auth.In;

import java.io.Serializable;

public class Personredis implements Serializable {//此类必须使用时间序列化接口，因为使用Jackson做序列化需要一个空构造
    private static final long servialVersionUID=1L;

    private String id;
    private String name;
    private Integer age;

    public Personredis()
    {
        super();
    }

    public Personredis(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
