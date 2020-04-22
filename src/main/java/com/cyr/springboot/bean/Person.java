package com.cyr.springboot.bean;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;

@Entity //注解指明这是一个和数据库表映射的实体类
@NamedQuery(name="Person.withNameAndAddressNamedQuery",query="select * from Person p where p.name=?1 and address=?2")
public class Person {//通过实体类生产表
    @Id//注解指明这个属性映射为数据库的主键
    @GeneratedValue//注解默认使用主键生产方式为自增，hibernate会为我们自动生产一个名为HIBERNATE_SEQUENCE的序列
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
        super();
    }

    public Person(Long id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //省略get set
}
