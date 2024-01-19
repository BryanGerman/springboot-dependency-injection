package com.bryanlema.springboot.app.dependencyinyection.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;
import com.bryanlema.springboot.app.dependencyinyection.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    @Qualifier("productRepositoryJson")
    private ProductRepository repository;

    @Autowired
    private Environment environment;

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double tax = environment.getProperty("config.price.tax", Double.class);
            Double price = p.getPrice() * tax;
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
