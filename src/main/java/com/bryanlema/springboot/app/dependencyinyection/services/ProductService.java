package com.bryanlema.springboot.app.dependencyinyection.services;

import java.util.List;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
