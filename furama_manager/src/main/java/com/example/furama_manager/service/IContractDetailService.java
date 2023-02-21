package com.example.furama_manager.service;

import com.example.furama_manager.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    List<ContractDetail> findContractDetailByContractId(int id);
}
