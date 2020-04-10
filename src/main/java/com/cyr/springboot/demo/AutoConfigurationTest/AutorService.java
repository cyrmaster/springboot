package com.cyr.springboot.demo.AutoConfigurationTest;

public class AutorService {
    private String name;
    private long age;

    public void service()
    {
        System.out.println ("AutoConfigueSucces,name="+name+"\nage="+age);
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public long getAge () {
        return age;
    }

    public void setAge (long age) {
        this.age = age;
    }
}
