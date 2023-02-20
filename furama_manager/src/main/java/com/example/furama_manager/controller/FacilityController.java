package com.example.furama_manager.controller;

import com.example.furama_manager.model.Facility;
import com.example.furama_manager.model.FacilityType;
import com.example.furama_manager.model.RentType;
import com.example.furama_manager.service.IFacilityService;
import com.example.furama_manager.service.IFacilityTypeService;
import com.example.furama_manager.service.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String getAll(Model model,
                         @RequestParam(defaultValue = "0") int page,
                         @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                         @RequestParam(name = "facilityTypeId", required = false, defaultValue = "") String id
                         ){
        Pageable pageable = PageRequest.of(page, 4);
        Page<Facility> facilityPage = this.facilityService.getAllAndSearch(keyword, id, pageable);
        List<FacilityType> facilityTypeList = this.facilityTypeService.findAll();
        List<RentType> rentTypeList = this.rentTypeService.findAll();
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facility", new Facility());
        return "/facility/list";
    }

    @PostMapping("/create")
    public String addFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        this.facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Add Success!");
        return "redirect:/facility";
    }

    @PostMapping("/edit")
    public String updateFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        this.facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Update Success!");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        Facility facility = this.facilityService.findById(deleteId);
        facility.setDeleted(true);
        this.facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/facility";
    }
}
