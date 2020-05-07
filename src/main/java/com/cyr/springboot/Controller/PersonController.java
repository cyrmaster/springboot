package com.cyr.springboot.Controller;

import com.cyr.springboot.Dao.PersonRepository;
import com.cyr.springboot.Dao.Redis.PersonRedisDao;
import com.cyr.springboot.Service.PersonService;
import com.cyr.springboot.bean.Person;
import com.cyr.springboot.bean.Personredis;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    PersonRedisDao personRedisDao;

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
    @ApiOperation ("回滚事务测试")
    @RequestMapping(value = "rollback",method = RequestMethod.POST)
    public Person savePersonWithRollBack(@RequestBody  Person person)
    {
       return personService.savePersonWithRollBack (person);
    }

    @ApiOperation (value = "不回滚事务测试")
    @RequestMapping(value = "norollback",method = RequestMethod.POST)
    public Person savePersonWithOutRollBack(@RequestBody Person person)
    {
        return personService.savePersonWithoutRollBack (person);
    }
    @ApiOperation(value = "无条件加入方法返回值入缓存")
    @CachePut(value = "people",key="#person.id")
    @RequestMapping(value = "savecache",method = RequestMethod.POST)
    public Person save(@RequestBody Person person)
    {
        Person p=personRepository.save(person);
        System.out.println("为id,key为："+p.getId()+"数据做了缓存");
        return p;
    }
    @ApiOperation(value = "从缓存中删除相关数据")
    @CachePut(value = "people")
    @RequestMapping(value = "deletecache",method = RequestMethod.DELETE)
    public void remove(Long id)
    {
        System.out.println("删除了id,key为："+id+"的数据缓存");
        personRepository.deleteById(id);
    }
    @ApiOperation(value = "有缓存返回，无返回加入")
    @CachePut(value = "people",key="#person.id")
    @RequestMapping(value = "findcache",method = RequestMethod.POST)
    public Optional<Person> find(@RequestBody Person person)
    {
        Optional<Person> p=personRepository.findById(person.getId());
        System.out.println("为id,key为："+person.getId()+"数据做了缓存");
        return p;
    }

    @ApiOperation(value ="RedisTemplate set，json传入对象")
    @RequestMapping(value = "/redisSet",method = RequestMethod.POST)
    public void set(@RequestBody Personredis person)
    {
        personRedisDao.save(person);
    }
    @ApiOperation(value = "StringRedisTemplate get,路径传参key ")
    @RequestMapping(value = "/redisGetStr/{key}",method = RequestMethod.GET)
    public String getStr(@PathVariable String key)
    {
        return personRedisDao.getString(key);
    }
    @ApiOperation(value = "RedisTemplate get,路径传参Key")
    @RequestMapping(value = "/redisGetPerson/{id}",method = RequestMethod.GET)
    public Personredis getPerson(@PathVariable String id)
    {
      return personRedisDao.getPerson(id);
    }
}
