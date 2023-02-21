package com.example.furama_manager.service;

import com.example.furama_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> search(String keyword, Pageable pageable);

    Page<Customer> findByCustomerTypeId(int customerTypeId, Pageable pageable);

    List<Customer> findAll();

    Customer findById(int id);

//    Customer save(Customer customer);
    boolean save(Customer customer);

}
