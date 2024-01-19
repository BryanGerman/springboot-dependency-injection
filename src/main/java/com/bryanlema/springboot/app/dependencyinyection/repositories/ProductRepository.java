package com.bryanlema.springboot.app.dependencyinyection.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;

@Repository
public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
