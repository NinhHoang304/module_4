package com.example.borrow_books.service;

import com.example.borrow_books.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetail> findAll();

    OrderDetail findById(int id);
    void save(OrderDetail orderDetail);
}
