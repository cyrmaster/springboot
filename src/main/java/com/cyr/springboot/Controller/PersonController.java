package com.cyr.springboot.Controller;

import com.cyr.springboot.Dao.PersonRepository;
import com.cyr.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age)
    {
        Person p=personRepository.save(new Person(null,name,age,address));
        return  p;
    }

    @RequestMapping("/findByAddress")
    public List<Person> findByAddress(String address)
    {
        List<Person> peoples=personRepository.findByAddress(address);
        return  peoples;
    }

    @RequestMapping("/findByNameAndAddress")
    public Person findByNameAndAddress(String name,String address)
    {
        Person person=personRepository.findByAddressAndName(name,address);
        return  person;
    }

    @RequestMapping("/withNameAndAddressQuery")
    public Person withNameAndAddressQuery(String name,String address)
    {
        Person person=personRepository.winthNameAndAddressQuery(name,address);
        return  person;
    }

    @RequestMapping("/withNameAndAddressNamedQuery")
    public Person withNameAndAddressNamedQuery(String name,String address)
    {
        Person person=personRepository.withNameAndAddressNamedQuery(name,address);
        return  person;
    }

    @RequestMapping("/sort")
    public List<Person> sort()
    {
        List<Person> peoples=personRepository.findAll(Sort.by(Direction.ASC,"age"));
        return  peoples;
    }

    @RequestMapping("/page")
    public Page<Person> page()
    {
        Page<Person> pagePeople=personRepository.findAll (PageRequest.of (1,2));
        return pagePeople;
    }
}
