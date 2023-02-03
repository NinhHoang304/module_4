package com.example.repository;

import com.example.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);
}
