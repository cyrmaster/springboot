package com.cyr.springboot.Mapper;


import com.cyr.springboot.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Results(id="product" ,value= {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "product_Name", column = "product_Name"),
            @Result(property = "price", column = "price"),
            @Result(property = "product_Brief", column = "product_Brief")
    })
    @Select("select * from product")
    public List<Product> find();

    @Select("select * from product where id = #{id}")
    public Product findByid(@Param("id") int id);

    @Insert("insert into product(id,product_Name,price,product_Brief) values(#{id},#{product_Name},#{price},#{product_Brief})")
    public int insertProduct(Product product);

    @Update("update product set product_Name=#{name} where id=#{id}")
    public int updateProduct(@Param("name")String name,@Param("id")int id);

    @Delete("delete from product where id=#{id}")
    public int deleteProdcutByid(@Param("id") int id);
}
