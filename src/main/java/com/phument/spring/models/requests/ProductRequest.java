package com.phument.spring.models.requests;

import com.phument.spring.models.Product;

public class ProductRequest {

    private  String name;

    private Float price;

    private Integer qty;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQty() {
        return qty;
    }

    public Product toEntity(){
        //create object
        Product product = new Product();

        //send data members to entity
        product.setName(this.name);
        product.setPrice(this.price);
        product.setQty(this.qty);

        return product;
    }





}
