package com.example.create_blog.controller;

import com.example.create_blog.model.Blog;
import com.example.create_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    //Delete
    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        this.blogService.delete(deleteId);
        redirectAttributes.addFlashAttribute("mess", "Delete success!");
        return "redirect:/";
    }

    //Edit
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        this.blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Update success!");
        return "redirect:/";
    }

}
