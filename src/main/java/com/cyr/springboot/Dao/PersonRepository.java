package com.cyr.springboot.Dao;

import com.cyr.springboot.bean.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByAddress(String address);

    Person findByAddressAndName(String address,String name);

    @Query("select  p from Person  p where  p.name=:name and p.address=:address")
    Person winthNameAndAddressQuery(@Param ("name")String name,@Param ("address")String address);

    Person withNameAndAddressNamedQuery(String name,String address);

    void deleteById(Long id);
    
    Optional<Person> findById(Long id);

}
