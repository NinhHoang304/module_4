package com.example.create_blog.service.impl;

import com.example.create_blog.model.Category;
import com.example.create_blog.repository.ICategoryRepository;
import com.example.create_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepository.deleteById(id);
    }
}
