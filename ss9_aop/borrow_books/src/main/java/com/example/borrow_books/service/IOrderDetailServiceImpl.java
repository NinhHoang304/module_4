package com.example.borrow_books.service;

import com.example.borrow_books.model.OrderDetail;
import com.example.borrow_books.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IOrderDetailServiceImpl implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return this.orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail findById(int id) {
        return this.orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        this.orderDetailRepository.save(orderDetail);
    }
}
