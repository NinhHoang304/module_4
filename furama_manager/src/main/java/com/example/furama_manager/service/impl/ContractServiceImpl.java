package com.example.furama_manager.service.impl;

import com.example.furama_manager.dto.IContractDto;
import com.example.furama_manager.model.Contract;
import com.example.furama_manager.repository.IContractRepository;
import com.example.furama_manager.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<IContractDto> getAllContracts(Pageable pageable) {
        return this.contractRepository.getAllContracts(pageable);
    }

    @Override
    public Contract findById(int id) {
        return this.contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }
}
