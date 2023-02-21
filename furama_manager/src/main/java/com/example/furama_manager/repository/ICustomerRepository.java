package com.example.furama_manager.repository;

import com.example.furama_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email, Pageable pageable);

    Page<Customer> findByCustomerTypeId(int customerTypeId, Pageable pageable);

    Customer findByIdCard(String idCard);

    Customer findByPhoneNumber(String phoneNumber);

    Customer findByEmail(String email);
}
