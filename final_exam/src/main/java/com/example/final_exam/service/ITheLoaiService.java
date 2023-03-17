package com.example.final_exam.service;

import com.example.final_exam.model.TheLoai;

import java.util.List;

public interface ITheLoaiService {
    List<TheLoai> findAll();

    TheLoai findById(int id);
}
