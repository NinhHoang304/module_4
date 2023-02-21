package com.example.furama_manager.repository;

import com.example.furama_manager.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    List<ContractDetail> findContractDetailByContractId(int id);
}
