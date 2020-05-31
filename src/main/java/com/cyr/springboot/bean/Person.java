package com.cyr.springboot.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity //注解指明这是一个和数据库表映射的实体类
@NamedQuery(name="Person.withNameAndAddressNamedQuery",query="select p from Person p where p.name=?1 and address=?2")
public class Person {//通过实体类生产表
    @GeneratedValue//注解默认使用主键生产方式为自增，hibernate会为我们自动生产一个名为HIBERNATE_SEQUENCE的序列
    @Id//注解指明这个属性映射为数据库的主键
    private Long id;

    @Size(max=4,min=2)
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //省略get set
}
