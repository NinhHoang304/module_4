package com.example.borrow_books.service;

import com.example.borrow_books.model.BookOrder;
import com.example.borrow_books.repository.IBookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOrderServiceImpl implements IBookOrderService{
    @Autowired
    private IBookOrderRepository bookOrderRepository;
    @Override
    public List<BookOrder> findAll() {
        return this.bookOrderRepository.findAll();
    }

    @Override
    public BookOrder findById(int id) {
        return this.bookOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookOrder bookOrder) {
        this.bookOrderRepository.save(bookOrder);
    }
}
