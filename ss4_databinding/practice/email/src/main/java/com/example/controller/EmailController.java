package com.example.controller;

import com.example.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @GetMapping("")
    public String showEmail(Model model){
        model.addAttribute("setting", new Setting());
        return "/setting";
    }

    @ModelAttribute("size")
    public String[] showPageSize(){
        return new String[]{"5", "10", "15", "25", "50", "100"};
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("setting") Setting setting, Model model){
        model.addAttribute("languages", setting.getLanguages());
        model.addAttribute("pageSize", setting.getPageSize());
        model.addAttribute("spamsFilter", setting.getSpamsFilter());
        model.addAttribute("signature", setting.getSignature());

        return "/result";
    }
}
