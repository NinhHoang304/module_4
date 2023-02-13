package com.example.borrow_books.controller;

import com.example.borrow_books.model.BookOrder;
import com.example.borrow_books.model.OrderDetail;
import com.example.borrow_books.service.IBookOrderService;
import com.example.borrow_books.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
public class BookOrderController {
    @Autowired
    private IBookOrderService bookOrderService;
    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("bookOrderList", this.bookOrderService.findAll());
        model.addAttribute("bookOrder", new BookOrder());
        return "/home";
    }

    @PostMapping("/order")
    public String order(@ModelAttribute BookOrder bookOrder, Model model, RedirectAttributes redirectAttributes) {
        Random random = new Random();
        String libCard = String.valueOf( random.nextInt(99999) + 1);
        if (bookOrder.getQuantity() == 0){
            return "/errors";
        }else {
            bookOrder.setQuantity(bookOrder.getQuantity() - 1);
            this.bookOrderService.save(bookOrder);
            redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công!");
            BookOrder bookOrder1 = new BookOrder(bookOrder.getId());
            OrderDetail orderDetail = new OrderDetail(libCard, bookOrder1);
            this.orderDetailService.save(orderDetail);
            return "redirect:/";
        }
    }

    @PostMapping("/remove")
    public String removeOrder(@RequestParam String libCard, RedirectAttributes redirectAttributes){
        BookOrder bookOrder;
        for (OrderDetail order: this.orderDetailService.findAll()) {
            if (order.getLibCard().equals(libCard)){
                bookOrder=this.bookOrderService.findById(order.getBookOrder().getId());
                bookOrder.setQuantity(bookOrder.getQuantity() + 1);
                this.bookOrderService.save(bookOrder);
                redirectAttributes.addFlashAttribute("mess", "Trả sách thành công!");
            }
        }
        return "redirect:/";
    }
}
