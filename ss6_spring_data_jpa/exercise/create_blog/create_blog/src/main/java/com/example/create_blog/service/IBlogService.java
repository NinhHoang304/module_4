package com.example.create_blog.service;

import com.example.create_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);
}
