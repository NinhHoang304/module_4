package com.example.shopping_cart.controller;

import com.example.shopping_cart.dto.CartDto;
import com.example.shopping_cart.dto.ProductDto;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
// tao session ten cart
@SessionAttributes("cart")
public class ProductController {
    // mapping bien cart vs bien session cart
    @ModelAttribute("cart")
    public CartDto initCard(){
        return new CartDto();
    }
    @Autowired
    private IProductService productService;
    @GetMapping
    public ModelAndView showListPage(Model model, @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                                     @CookieValue(value = "productId", required = false, defaultValue = "-1") Long id){
        // hien thi san pham xem gan nhat
        model.addAttribute("historyProduct", this.productService.findById(id));
        if (cartDto != null){
            model.addAttribute("cart", cartDto);
        }
        return new ModelAndView("shop", "productList", this.productService.findAll());
    }
    // tim id xem chi tiet
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id, HttpServletResponse response){
        // tao cookie de luu lich su xem san pham gan nhat
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail", "product", this.productService.findById(id));
    }
    // them moi gio hang
    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute(value = "cart") CartDto cart){
        Product product = this.productService.findById(id);
        if (product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/";
    }
}
