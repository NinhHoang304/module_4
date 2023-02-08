package com.example.create_blog.service.impl;

import com.example.create_blog.model.Blog;
import com.example.create_blog.repository.IBlogRepository;
import com.example.create_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findByNameContaining(String name, Pageable pageable) {
        return this.blogRepository.findByNameContaining(name, pageable);
    }
}
