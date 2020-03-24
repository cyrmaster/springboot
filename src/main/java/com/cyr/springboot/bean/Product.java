package com.cyr.springboot.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Product")
public class Product {
    @JacksonXmlProperty(localName = "id")
    private int id;
    /**商品名称*/
    @JacksonXmlProperty(localName = "productName")
    private String product_Name;
    /**商品价格*/
    @JacksonXmlProperty(localName = "price")
    private Float price;
    /**商品简介*/
    @JacksonXmlProperty(localName = "productBrief")
    private String product_Brief;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProduct_Brief() {
        return product_Brief;
    }

    public void setProduct_Brief(String product_Brief) {
        this.product_Brief = product_Brief;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_Name='" + product_Name + '\'' +
                ", price=" + price +
                ", product_Brief='" + product_Brief + '\'' +
                '}';
    }
}
