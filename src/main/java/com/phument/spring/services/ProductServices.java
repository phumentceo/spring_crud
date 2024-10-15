package com.phument.spring.services;

import com.phument.spring.models.Product;
import com.phument.spring.models.requests.ProductRequest;
import com.phument.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices{
    //Dependency injection
    @Autowired
    private ProductRepository repo;


    //Select Products
    public List<Product> select(){
        return  repo.findAll();
    }

    //Save Product
    public Product save(ProductRequest request){
        //convert product request to entity
        Product product = request.toEntity();
        return this.repo.save(product);
    }

    //Update Product
    public Product update(Long id,ProductRequest request){
        Product product = repo.findById(id).orElse(null);
        if(product != null){

            //update
            product.setName(( request.getName() != "" ? request.getName() : product.getName() ));
            product.setPrice(( request.getPrice() != null ? request.getPrice() : product.getPrice() ));
            product.setQty(( request.getQty() != null ? request.getQty() : product.getQty() ));

            //save new data
            return this.repo.save(product);
        }else{
            return null;
        }

    }

    //Select product by id
    public Product selectById(Long id){

        return repo.findById(id).orElse(null);
    }

    public void delete(Long id){
        Product product = repo.findById(id).orElse(null);
        repo.delete(product);
    }

}
