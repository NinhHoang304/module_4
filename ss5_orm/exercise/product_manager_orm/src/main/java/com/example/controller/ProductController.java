package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = this.productService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("product", new Product());
        return "/index";
    }

    // delete
    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        this.productService.remove(deleteId);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/";
    }

    //create
    @PostMapping("/create")
    public String save(Product product, RedirectAttributes redirectAttributes){
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/";
    }

    //update
    @PostMapping("/edit")
    public String update(Product product, RedirectAttributes redirectAttributes){
        this.productService.update(product);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/";
    }

    //search
    @PostMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("productList", this.productService.search(name));
        return "/index";
    }
}
