package com.example.furama_manager.controller;

import com.example.furama_manager.dto.IContractDto;
import com.example.furama_manager.model.AttachFacility;
import com.example.furama_manager.model.Contract;
import com.example.furama_manager.model.ContractDetail;
import com.example.furama_manager.service.IAttachFacilityService;
import com.example.furama_manager.service.IContractDetailService;
import com.example.furama_manager.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("")
    public String getAll(Model model,
                         @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 4);
        Page<IContractDto> contractPage = this.contractService.getAllContracts(pageable);
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("contract", new Contract());
        List<AttachFacility> attachFacilityList = this.attachFacilityService.findAll();
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contract/list";
    }
    @GetMapping("/detail")
    public String getContractDetail(@RequestParam int id, Model model, RedirectAttributes redirectAttributes){
        List<ContractDetail> contractDetailList = this.contractDetailService.findContractDetailByContractId(id);
        if (contractDetailList != null){
            redirectAttributes.addFlashAttribute("contractDetailList", contractDetailList);
            redirectAttributes.addFlashAttribute("hasTrue", "true");
            return "redirect:/contract";
        }
        return "redirect:/contract";
    }


    @PostMapping("/create")
    public String addContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        this.contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("mess", "Add Attach Facility Success!");
        return "redirect:/contract";
    }
}
