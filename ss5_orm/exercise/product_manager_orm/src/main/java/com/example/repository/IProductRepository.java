package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save (Product product);

    void update (Product product);

    void remove(int id);

    List<Product> search(String name);
}
