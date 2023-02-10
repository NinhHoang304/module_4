package com.example.validate_info_sing.controller;

import com.example.validate_info_sing.dto.SongDto;
import com.example.validate_info_sing.model.Song;
import com.example.validate_info_sing.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String index(Model model){
        List<Song> songList = this.songService.findAll();
        model.addAttribute("songList", songList);
        model.addAttribute("songDto", new SongDto());
        return "/index";
    }

    //Create song
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto", songDto);
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Added Success!");
        return "redirect:/";
    }

    //Edit song
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable int id, Model model){
//        SongDto songDto = new SongDto();
//        BeanUtils.copyProperties(this.songService.findById(id), songDto);
//        model.addAttribute("songDto", songDto);
//        return "/edit";
//    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("songList", this.songService.findAll());
            model.addAttribute("songDto", songDto);
            model.addAttribute("hasErr", "true");
            return "/index";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Edited Success!");
        return "redirect:/";
    }
}
