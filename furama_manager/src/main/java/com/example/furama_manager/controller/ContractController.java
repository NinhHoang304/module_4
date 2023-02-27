package com.example.furama_manager.controller;

import com.example.furama_manager.dto.IContractDto;
import com.example.furama_manager.model.*;
import com.example.furama_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;

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
        List<Customer> customerList = this.customerService.findAll();
        List<Facility> facilityList = this.facilityService.findAll();
        model.addAttribute("customerList", customerList);
        model.addAttribute("facilityList", facilityList);
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

    @PostMapping("/add")
    public String addAtt(@ModelAttribute Contract contract,
                      @ModelAttribute ContractDetail contractDetail,
                      RedirectAttributes redirectAttributes){
        Contract contract1 = this.contractService.findById(contract.getId());
        String checkInDate = contract1.getStartDate();
        String checkOutDate = contract1.getEndDate();
        LocalDate startDate = LocalDate.parse(checkInDate);
        LocalDate endDate = LocalDate.parse(checkOutDate);
        LocalDate currentDate = LocalDate.now();
        int yearOfStartDate = Period.between(startDate, currentDate).getYears();
        int yearOfEndDate = Period.between(endDate, currentDate).getYears();
        if (yearOfStartDate < yearOfEndDate){
            redirectAttributes.addFlashAttribute("checkDate", "Start date không được nhỏ hơn End date");
            redirectAttributes.addFlashAttribute("hasErr", "true");
            return "redirect:/contract";
        }
        this.contractService.save(contract);
        contractDetail.setContract(contract);
        this.contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }
}
