package com.cyr.springboot.Service;

import com.cyr.springboot.bean.Person;

public interface PersonService {
    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithoutRollBack(Person person);
}
