package com.cyr.springboot.Service;

import com.cyr.springboot.Dao.PersonRepository;
import com.cyr.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerosonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person savePersonWithRollBack (Person person) {
        return null;
    }

    @Override
    public Person savePersonWithoutRollBack (Person person) {
        return null;
    }
}
