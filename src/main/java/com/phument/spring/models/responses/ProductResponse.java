package com.phument.spring.models.responses;

import com.phument.spring.models.Product;

public class ProductResponse {
    private Long id;

    private  String name;

    private  Float price;

    private  Integer qty;

    //Constructors
    public ProductResponse(Long id,String name,Float price,Integer qty){
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }


    //From Entity
    public static ProductResponse fromEntity(Product product){

        return new ProductResponse(product.getId(),product.getName(),product.getPrice(),product.getQty());

    }





}
