package com.cyr.springboot.Controller;

import com.cyr.springboot.Mapper.ProductMapper;
import com.cyr.springboot.Service.ProductService;
import com.cyr.springboot.bean.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Resource
    private ProductService productService;

    @ApiOperation(value="获取商品集合", notes="获取表里的全部商品")
    @RequestMapping(value = "/findProduct",method = RequestMethod.GET)
    public List<Product> find(){
        List<Product> products=productService.find();
        return  products;
    }

    @ApiOperation(value="获取商品", notes="通过id获取商品")
    @RequestMapping(value ="/findByid/{id}",method = RequestMethod.GET)
    public String findByid(@PathVariable int id){
        Product product=productService.findByid(id);
        return product.toString();
    }

    @ApiOperation(value="添加商品", notes="")
    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public  String addProduct(@RequestBody Product product)
    {
        Product temp=new Product();
        temp.setId(product.getId());
        temp.setPrice(product.getPrice());
        temp.setProduct_Brief(product.getProduct_Brief());
        temp.setProduct_Name(product.getProduct_Name());
        return  String.valueOf(productService.insertProduct(temp));
    }

    @ApiOperation(value="删除商品", notes="通过id删除")
    @RequestMapping(value = "/deleteByid/{id}",method =RequestMethod.DELETE)
    public int deleteByid(@PathVariable int id)
    {
        return  productService.deleteProductByid(id);
    }

    @ApiOperation(value="更新商品", notes="")
    @RequestMapping(value = "/updateProduct",method = RequestMethod.PUT)
    public int updateProduct(@RequestBody Product product)
    {
       return productService.updateProductByid(product);
    }

    @ApiOperation(value="Thymeleaf试验接口", notes="")
    @RequestMapping(value = "/Thymeleaf",method = RequestMethod.GET)
    public String index(ModelMap modelMap)
    {
        modelMap.addAttribute("hello","helloworld");
        return "index";
    }

}