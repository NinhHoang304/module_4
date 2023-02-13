package com.example.borrow_books.repository;

import com.example.borrow_books.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookOrderRepository extends JpaRepository<BookOrder, Integer> {
}
