package com.bryanlema.springboot.app.dependencyinyection.repositories;

import java.util.Arrays;
import java.util.List;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini 60", 180L),
            new Product(4L, "MotherBoard Gibabyte", 490L)
        );
    }

    public List<Product> findAll(){
        return this.data;
    }

    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}