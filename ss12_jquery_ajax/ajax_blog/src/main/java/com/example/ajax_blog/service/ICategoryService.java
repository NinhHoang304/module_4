package com.example.ajax_blog.service;

import com.example.ajax_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void delete(int id);
}
