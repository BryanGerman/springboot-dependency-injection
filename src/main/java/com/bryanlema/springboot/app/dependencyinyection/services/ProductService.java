package com.bryanlema.springboot.app.dependencyinyection.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;
import com.bryanlema.springboot.app.dependencyinyection.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * 1.25d;
            p.setPrice(price.longValue());
            return p;
        }).collect(Collectors.toList());
    };

    public Product findById(Long id){
        return repository.findById(id);
    }
}
