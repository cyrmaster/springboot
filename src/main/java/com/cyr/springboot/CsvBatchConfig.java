package com.cyr.springboot;

import com.cyr.springboot.bean.Person;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class CsvBatchConfig {
    @Bean
    public ItemReader<Person> reader() throws Exception {
        FlatFileItemReader<Person> reader=new FlatFileItemReader<Person>();//使用FlatFileItemReader读取文件
        reader.setResource(new ClassPathResource("penson.csv"));//设置文件路径
        reader.setLineMapper(new DefaultLineMapper<Person>(){{//对cvs文件的数据和领域模型类做对应映射
            setLineTokenizer(new DelimitedLineTokenizer(){{
                setNames(new String [] {"id","name","age","address"});
            }});
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){{
                    setTargetType(Person.class);
                }});
        }});
                return reader;
    }
}
