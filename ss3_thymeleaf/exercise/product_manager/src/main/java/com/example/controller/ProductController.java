package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    // Display list
    @GetMapping("")
    public String index(Model model){
        List<Product> productList = this.productService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }
}
