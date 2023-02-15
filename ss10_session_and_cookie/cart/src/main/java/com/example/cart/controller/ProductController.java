package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart(){
        return new CartDto();
    }

    @GetMapping("")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("productList", this.productService.findAll());
        return modelAndView;
    }

    // chuyen qua trang detail sau khi bam xem chi tiet
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable long id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }

    @GetMapping("/cart/add/{id}")
    public String addtoCart(@PathVariable Long id, @SessionAttribute(value = "cart") CartDto cart){
        Product product = this.productService.findById(id);
        if (product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
