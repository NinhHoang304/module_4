package com.example.create_blog.controller;

import com.example.create_blog.model.Blog;
import com.example.create_blog.model.Category;
import com.example.create_blog.service.IBlogService;
import com.example.create_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    //List
    @GetMapping("")
    public String index(Model model, @RequestParam(required = false, defaultValue = "") String nameSearch,
                        @PageableDefault(size = 4, page = 0, sort = "day",
                        direction = Sort.Direction.DESC) Pageable pageable){
        List<Blog> blogList = this.blogService.findAll();
        model.addAttribute("blogList", blogList);
        List<Category> categoryList = this.categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        Page<Blog> blogPage = this.blogService.findByNameContaining(nameSearch, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("nameSearch", nameSearch);
        return "/layout";
    }

    //Creat
    @GetMapping("/create")
    public String showFormCreate(Model model){
        List<Category> categoryList = this.categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
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
        List<Category> categoryList = this.categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        this.blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Update success!");
        return "redirect:/";
    }

}
