package com.example.furama_manager.service.impl;

import com.example.furama_manager.model.Customer;
import com.example.furama_manager.repository.ICustomerRepository;
import com.example.furama_manager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getCustomerByQuery(String keyword, String customerTypeName, Pageable pageable) {
        return this.customerRepository.getCustomerByQuery(keyword, keyword, customerTypeName, pageable);
    }

    @Override
    public Page<Customer> search(String keyword, Pageable pageable) {
        return this.customerRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, pageable);
    }

    @Override
    public Page<Customer> findByCustomerTypeId(int customerTypeId, Pageable pageable) {
        return this.customerRepository.findByCustomerTypeId(customerTypeId, pageable);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Customer customer) {
        if (customer != null){
            this.customerRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public String checkDuplicate(String email, String phoneNumber, String idCard) {
        List<Customer> customerList = this.customerRepository.findAll();
        for (Customer item : customerList){
            if (item.getEmail().equals(email)){
                return "Error, email is duplicate!";
            }
            if (item.getPhoneNumber().equals(phoneNumber)){
                return "Error, phone number is duplicate!";
            }
            if (item.getIdCard().equals(idCard)){
                return "Error, Id card is duplicate!";
            }
        }
        return null;
    }
}
