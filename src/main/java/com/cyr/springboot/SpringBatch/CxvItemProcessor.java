package com.cyr.springboot.SpringBatch;

import com.cyr.springboot.bean.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

public class CxvItemProcessor extends ValidatingItemProcessor<Person> {
    @Override
    public Person process(Person item) throws ValidationException {

        super.process(item);//需执行super.proces(item)才会调用自定义校验器。
        if(item.getAddress().contains("中国"))
        {
            item.setName("China"+item.getName());
        }
        return  item;
    }
}
