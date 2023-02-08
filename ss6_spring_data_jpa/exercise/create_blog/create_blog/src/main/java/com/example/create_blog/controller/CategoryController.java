package com.example.create_blog.controller;

import com.example.create_blog.model.Category;
import com.example.create_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showListCategory(Model model){
        List<Category> categoryList = this.categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("category", new Category());
        return "/category";
    }

    // add new category
    @PostMapping("/create")
    public String addNewCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        this.categoryService.add(category);
        redirectAttributes.addFlashAttribute("mess", "Added Success!");
        return "redirect:/category";
    }

    //update
    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        this.categoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Updated Success!");
        return "redirect:/category";
    }

    //delete
    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        this.categoryService.delete(deleteId);
        redirectAttributes.addFlashAttribute("mess", "Deleted Success!");
        return "redirect:/category";
    }
}
