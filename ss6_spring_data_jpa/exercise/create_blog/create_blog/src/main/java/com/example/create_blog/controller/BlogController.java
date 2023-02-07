package com.example.create_blog.controller;

import com.example.create_blog.model.Blog;
import com.example.create_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    //List
    @GetMapping("")
    public String index(Model model){
        List<Blog> blogList = this.blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/layout";
    }

    //Creat
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }
    @PostMapping("/add")
    public String addBlog(Blog blog, RedirectAttributes redirectAttributes){
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add blog success!");
        return "redirect:/";
    }
}
