package com.bryanlema.springboot.app.dependencyinyection.repositories;

import java.util.List;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
