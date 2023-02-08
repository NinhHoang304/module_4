package com.example.create_blog.service;

import com.example.create_blog.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(int id);

    void add(Category category);

    void update(Category category);

    void delete(int id);
}
