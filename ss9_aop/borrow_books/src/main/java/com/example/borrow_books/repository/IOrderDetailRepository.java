package com.example.borrow_books.repository;

import com.example.borrow_books.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
