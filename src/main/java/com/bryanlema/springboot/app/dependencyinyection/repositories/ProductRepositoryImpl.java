package com.bryanlema.springboot.app.dependencyinyection.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;

@Repository("productList")
 @Primary
public class ProductRepositoryImpl implements ProductRepository{
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 40", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini 60", 180L),
            new Product(4L, "MotherBoard Gibabyte", 490L)
        );
    }

    public List<Product> findAll(){
        return this.data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
