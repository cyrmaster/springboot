package com.cyr.springboot.Service;

import com.cyr.springboot.Mapper.ProductMapper;
import com.cyr.springboot.bean.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductMapper productMapper;

    public List<Product> find()
    {
        return  productMapper.find( );
    }
    public Product findByid(int i)
    {
        return  productMapper.findByid(i);
    }

    public int insertProduct(Product product)
    {
        return productMapper.insertProduct(product);
    }

    public  int updateProductByid(Product product)
    {
        return productMapper.updateProduct(product.getProduct_Name(),product.getId());
    }

    public int deleteProductByid(int id)
    {
        return productMapper.deleteProdcutByid(id);
    }
}
