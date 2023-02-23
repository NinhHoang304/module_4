package com.example.furama_manager.dto;

import com.example.furama_manager.model.AttachFacility;

public class ContractDetailDto {
    private ContractDto contractDto;
    private AttachFacility attachFacility;
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(ContractDto contractDto, AttachFacility attachFacility, int quantity) {
        this.contractDto = contractDto;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public ContractDto getContractDto() {
        return contractDto;
    }

    public void setContractDto(ContractDto contractDto) {
        this.contractDto = contractDto;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
