package com.cyr.springboot;

import com.cyr.springboot.demo.TestProperties;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
class SpringbootApplicationTests {

    @Resource
    private TestProperties testProperties;
    @Test
    public void test() {
        Assert.assertEquals("test",testProperties.getTestname());
    }

}
