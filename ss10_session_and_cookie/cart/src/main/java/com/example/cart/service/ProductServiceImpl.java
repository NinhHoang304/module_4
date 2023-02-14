package com.example.cart.service;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        this.productRepository.deleteById(id);
    }
}
