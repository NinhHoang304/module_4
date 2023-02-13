package com.example.furama_resort.service;

import com.example.furama_resort.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void delete(int id);
}
