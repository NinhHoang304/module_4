package com.example.ajax_blog.service;

import com.example.ajax_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findByNameContaining(Pageable pageable, String name);

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);
}
