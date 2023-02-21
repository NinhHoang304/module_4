package com.example.furama_manager.service;

import com.example.furama_manager.dto.IContractDto;
import com.example.furama_manager.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractDto> getAllContracts(Pageable pageable);
}
