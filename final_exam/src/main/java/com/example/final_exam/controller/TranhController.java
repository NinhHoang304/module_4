package com.example.final_exam.controller;

import com.example.final_exam.model.TheLoai;
import com.example.final_exam.model.Tranh;
import com.example.final_exam.service.ITheLoaiService;
import com.example.final_exam.service.ITranhService;
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
@RequestMapping("/tranh")
public class TranhController {
    @Autowired
    private ITranhService tranhService;

    @Autowired
    private ITheLoaiService theLoaiService;

    @GetMapping("")
    public String getAll(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(name = "tenTacPham", defaultValue = "", required = false) String tenTacPham,
                         @RequestParam(name = "tenTheLoai", defaultValue = "", required = false) String tenTheLoai,
                         Model model, RedirectAttributes redirectAttributes){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Tranh> tranhPage = this.tranhService.findTranh(tenTacPham, tenTheLoai, pageable);
        model.addAttribute("tranhPage", tranhPage);
        List<TheLoai> theLoaiList = this.theLoaiService.findAll();
        model.addAttribute("theLoaiList", theLoaiList);
        model.addAttribute("tranh", new Tranh());
        return "/list";
    }

    @PostMapping("/create")
    public String addNew(@ModelAttribute Tranh tranh, RedirectAttributes redirectAttributes){
        this.tranhService.save(tranh);
        redirectAttributes.addFlashAttribute("mess", "Add Thanh Cong");
        return "redirect:/tranh";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        Tranh tranh = this.tranhService.findById(deleteId);
        tranh.setDeleted(true);
        this.tranhService.save(tranh);
        redirectAttributes.addFlashAttribute("mess", "xoa Thanh Cong");
        return "redirect:/tranh";
    }
}
