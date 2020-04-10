package com.cyr.springboot.demo.AutoConfigurationTest;

import com.cyr.springboot.bean.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Author.class) //声明Author交给IOC容器管理,否则下面的autowired注入不了
@ConditionalOnClass(AutorService.class)
@ConditionalOnProperty(prefix = "author",value = "enable",matchIfMissing = true)
public class AutorServiceConfiguration {
     @Autowired
    Author author;
     @Bean
     @ConditionalOnMissingBean(AutorService.class)
     public AutorService autorService()
     {
         AutorService autorService=new AutorService ();
         autorService.setName (author.getName ());
         autorService.setAge (author.getAge ());
         return  autorService;
     }
}
