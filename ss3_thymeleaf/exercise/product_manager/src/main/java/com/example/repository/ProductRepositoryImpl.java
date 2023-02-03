package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    private static final Map<Integer, Product> productList = new HashMap<>();
    static {
        productList.put(1, new Product(1, "Iphone 12", 2500, "Black", "Apple"));
        productList.put(2, new Product(2, "Iphone 13", 3000, "Gold", "Apple"));
        productList.put(3, new Product(3, "Iphone 14", 4600, "Purple", "Apple"));
        productList.put(4, new Product(4, "Samsung Fold", 2000, "Diamond", "Samsung"));
        productList.put(5, new Product(5, "Samsung Flip", 3000, "Blue", "Samsung"));
        productList.put(6, new Product(6, "Oppo", 1500, "White", "Oppo"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
