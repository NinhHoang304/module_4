package com.example.furama_manager.service.impl;

import com.example.furama_manager.model.ContractDetail;
import com.example.furama_manager.repository.IContractDetailRepository;
import com.example.furama_manager.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }
    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }
}
