package com.example.furama_manager.controller;

import com.example.furama_manager.dto.CustomerDto;
import com.example.furama_manager.model.Customer;
import com.example.furama_manager.model.CustomerType;
import com.example.furama_manager.service.ICustomerService;
import com.example.furama_manager.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String getAllCustomers(Model model,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                  @RequestParam(name = "customerTypeName", required = false, defaultValue = "") String customerTypeName){
        Pageable pageable = PageRequest.of(page, 4);
        Page<Customer> customerPage = this.customerService.getCustomerByQuery(keyword, customerTypeName, pageable);
        model.addAttribute("customerPage", customerPage);
        List<CustomerType> customerTypeList = this.customerTypeService.getAllCustomerType();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/list";
    }

    @PostMapping("/create")
    public String addCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model){
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()){
            Page<Customer> customerPage = this.customerService.getCustomerByQuery("", "", PageRequest.of(0, 4));
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("customerDto", customerDto);
            List<CustomerType> customerTypeList = this.customerTypeService.getAllCustomerType();
            model.addAttribute("customerTypeList", customerTypeList);
            model.addAttribute("hasErr", "true");
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        String checkDuplicate = this.customerService.checkDuplicate(customer.getEmail(), customer.getPhoneNumber(), customer.getIdCard());
        if (checkDuplicate != null){
            redirectAttributes.addFlashAttribute("error", checkDuplicate);
            redirectAttributes.addFlashAttribute("hasErr", "true");
            return "redirect:/customer";
        }
        boolean check = this.customerService.save(customer);
        if (!check){
            redirectAttributes.addFlashAttribute("mess", "Not Success, please try again!");
        }
        redirectAttributes.addFlashAttribute("mess", "Create Success!");
        return "redirect:/customer";
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        boolean check = this.customerService.save(customer);
        if (!check){
            redirectAttributes.addFlashAttribute("mess", "Not Success, please try again!");
        }
        redirectAttributes.addFlashAttribute("mess", "Update Success!");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String removeCustomer(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        Customer customer = this.customerService.findById(deleteId);
        customer.setDeleted(true);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Delete Success!");
        return "redirect:/customer";
    }
}
