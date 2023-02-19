package com.example.furama_manager.service.impl;

import com.example.furama_manager.model.CustomerType;
import com.example.furama_manager.repository.ICustomerTypeRepository;
import com.example.furama_manager.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getAllCustomerType() {
        return this.customerTypeRepository.findAll();
    }
}
