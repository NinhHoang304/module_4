package com.example.borrow_books.controller;

import com.example.borrow_books.model.OrderDetail;
import com.example.borrow_books.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookOrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping("/detail")
    public String orderDetail(Model model){
        model.addAttribute("orderDetailList", this.orderDetailService.findAll());
        model.addAttribute("orderDetail", new OrderDetail());
        return "/detail";
    }
}
