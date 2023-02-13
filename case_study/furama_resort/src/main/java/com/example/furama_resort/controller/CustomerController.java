package com.example.furama_resort.controller;

import com.example.furama_resort.model.Customer;
import com.example.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String formCustomer(Model model){
        model.addAttribute("customerList", this.customerService.findAll());
        model.addAttribute("customer", new Customer());
        return "/customer";
    }

    //Create
    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer, Model model, RedirectAttributes redirectAttributes){
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Added Success!");
        return "redirect:/customer";
    }
}
