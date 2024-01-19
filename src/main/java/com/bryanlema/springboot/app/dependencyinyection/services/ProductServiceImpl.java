package com.bryanlema.springboot.app.dependencyinyection.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;
import com.bryanlema.springboot.app.dependencyinyection.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * 1.25d;
            //Product product = new Product(p.getId(), p.getName(), price.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(price.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    };

    public Product findById(Long id){
        return repository.findById(id);
    }
}
