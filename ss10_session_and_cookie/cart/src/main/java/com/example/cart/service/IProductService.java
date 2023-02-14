package com.example.cart.service;

import com.example.cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(long id);

    void save(Product product);

    void delete(long id);
}
