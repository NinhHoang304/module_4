package com.example.furama_resort.service.impl;

import com.example.furama_resort.model.Customer;
import com.example.furama_resort.repository.ICustomerRepository;
import com.example.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);
    }
}
