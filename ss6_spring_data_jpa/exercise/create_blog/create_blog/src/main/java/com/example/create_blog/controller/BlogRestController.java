package com.example.create_blog.controller;

import com.example.create_blog.model.Blog;
import com.example.create_blog.model.Category;
import com.example.create_blog.service.IBlogService;
import com.example.create_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    // tim kiem


    // hien thi danh sach blog
    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogList = this.blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    // hien thi danh sach category
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = this.categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    // hien thi chi tiet
    @GetMapping("/{id}")
    public ResponseEntity getDetailBlog(@PathVariable int id){
        Blog detailBlog = this.blogService.findById(id);
        if (detailBlog == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(detailBlog, HttpStatus.OK);
    }

     //hien danh sach theo category
    @GetMapping("/category/{id}")
    public ResponseEntity getBlogWithCategory(@PathVariable int id){
        Category category = this.categoryService.findById(id);
        Set<Blog> categoryList = category.getBlogSet();
        if (category == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(categoryList, HttpStatus.OK);
    }
}
