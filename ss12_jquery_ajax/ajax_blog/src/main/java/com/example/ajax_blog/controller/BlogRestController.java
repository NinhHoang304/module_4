package com.example.ajax_blog.controller;

import com.example.ajax_blog.model.Blog;
import com.example.ajax_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    // get list
    @GetMapping("")
    public ResponseEntity<Page<Blog>> pagingAndSearch(@RequestParam(required = false, defaultValue = "") String name,
                                 @RequestParam(required = false,defaultValue = "4") int pageSize){
        Pageable pageable = PageRequest.of(0,pageSize);
        Page<Blog> blogPage = this.blogService.findByNameContaining(pageable, name);
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

}
