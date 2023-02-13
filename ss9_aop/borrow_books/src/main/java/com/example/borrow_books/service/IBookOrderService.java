package com.example.borrow_books.service;

import com.example.borrow_books.model.BookOrder;

import java.util.List;

public interface IBookOrderService {
    List<BookOrder> findAll();

    BookOrder findById(int id);

    void save(BookOrder bookOrder);

}
