package com.example.furama_manager.controller;

import com.example.furama_manager.dto.ContractDetailDto;
import com.example.furama_manager.model.Contract;
import com.example.furama_manager.model.ContractDetail;
import com.example.furama_manager.service.IContractDetailService;
import com.example.furama_manager.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ContractRestController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;

    @PostMapping("/contract/save")
    public ResponseEntity save(@RequestBody List<ContractDetailDto> contractDetailDtoList){
        if (contractDetailDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDetailDtoList.get(0).getContractDto(), contract);
        this.contractService.save(contract);
        for (ContractDetailDto item : contractDetailDtoList){
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(item, contractDetail);
            contractDetail.setContract(contract);
            this.contractDetailService.save(contractDetail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
