package com.cyr.springboot.Dao;

import com.cyr.springboot.bean.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByAddress(String address);

    Person findByAddressAndName(String address,String name);

    @Query("select  p from Person  p where  p.name=:name and p.address=:address")
    Person winthNameAndAddressQuery(@Param ("name")String name,@Param ("address")String address);

    Person withNameAndAddressNamedQuery(String name,String address);

}
