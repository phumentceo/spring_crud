package com.phument.spring.controllers;

import com.phument.spring.models.Product;
import com.phument.spring.models.requests.ProductRequest;
import com.phument.spring.models.responses.ProductResponse;
import com.phument.spring.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    //injection
    @Autowired
    private ProductServices services;

    //Select all Products
    @GetMapping
    public ResponseEntity<List<ProductResponse>> index(){

        List<ProductResponse> products = this.services.select().stream().map(ProductResponse::fromEntity).toList();

        return ResponseEntity.ok(products);
    }

    //Single Select
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> edit(@PathVariable Long id){
        Product product = this.services.selectById(id);
        return ResponseEntity.ok(ProductResponse.fromEntity(product));
    }


    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
        Product product = this.services.save(request);
        return  ResponseEntity.ok(ProductResponse.fromEntity(product));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,@RequestBody ProductRequest request){
        Product product = this.services.update(id,request);
        return ResponseEntity.ok(ProductResponse.fromEntity(product));
    }



}
