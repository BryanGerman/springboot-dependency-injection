package com.bryanlema.springboot.app.dependencyinyection.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;

import com.bryanlema.springboot.app.dependencyinyection.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository {

    private List<Product> list;

    public ProductRepositoryJson(Resource resource) {
        //Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper json = new ObjectMapper();
        try {
            list = Arrays.asList(json.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p ->p.getId().equals(id)).findFirst().orElseThrow();
    }

}
