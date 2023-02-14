package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public CartDto setupCart(){
        return new CartDto();
    }

    @GetMapping("/cart")
    public ModelAndView showCart(@SessionAttribute(value = "cart") CartDto cartDto){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cartDto);
        return modelAndView;
    }
}
