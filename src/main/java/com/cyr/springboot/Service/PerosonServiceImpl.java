package com.cyr.springboot.Service;

import com.cyr.springboot.Dao.PersonRepository;
import com.cyr.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerosonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})//指定特定异常时回滚
    public Person savePersonWithRollBack (Person person) {
        Person p=personRepository.save (person);
        if(p.getName ().equals ("cyr"))
        {
            throw  new IllegalArgumentException ("cyr已存在，数据将回滚");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})//指定哪个异常不引起回滚
    public Person savePersonWithoutRollBack (Person person) {
        Person p=personRepository.save (person);
        if(p.getName ().equals ("cyr"))
        {
            throw  new IllegalArgumentException ("cyr虽已存在，数据将不会回滚");
        }
        return p;
    }
    }

