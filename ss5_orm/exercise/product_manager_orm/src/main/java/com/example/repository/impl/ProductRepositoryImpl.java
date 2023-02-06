package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        productList = entityManager.createQuery("FROM Product").getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }
    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }
    @Transactional
    @Override
    public void update(Product product) {
        Product product1 = findById(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setBrand(product.getBrand());
        entityManager.merge(product1);
    }
    @Transactional
    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> search(String name) {
//        List<Product> productList = null;
//        productList = entityManager.createQuery("Select p from Product as p where p.name like :param").setParameter("param","%"+name+"%").getResultList();
        List<Product>productList=new ArrayList<>();
        for (Product p:findAll()) {
            if (p.getName().contains(name)){
                productList.add(p);
            }
        }
        return productList;

    }
}
