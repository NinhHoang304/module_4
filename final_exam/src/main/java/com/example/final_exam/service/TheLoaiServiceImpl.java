package com.example.final_exam.service;

import com.example.final_exam.model.TheLoai;
import com.example.final_exam.repository.ITheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheLoaiServiceImpl implements ITheLoaiService{
    @Autowired
    private ITheLoaiRepository theLoaiRepository;
    @Override
    public List<TheLoai> findAll() {
        return this.theLoaiRepository.findAll();
    }

    @Override
    public TheLoai findById(int id) {
        return this.theLoaiRepository.findById(id).orElse(null);
    }
}
