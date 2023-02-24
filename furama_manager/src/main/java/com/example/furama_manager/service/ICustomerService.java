package com.example.furama_manager.service;

import com.example.furama_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> getCustomerByQuery(String keyword, String customerTypeName, Pageable pageable);
    Page<Customer> search(String keyword, Pageable pageable);

    Page<Customer> findByCustomerTypeId(int customerTypeId, Pageable pageable);

    List<Customer> findAll();

    Customer findById(int id);

    boolean save(Customer customer);

    String checkDuplicate(String email, String phoneNumber, String idCard);
}
