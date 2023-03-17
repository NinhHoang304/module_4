package com.example.final_exam.service;

import com.example.final_exam.model.Tranh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITranhService {
    Page<Tranh> findTranh(String tenTacPham, String tenTheLoai, Pageable pageable);

    Tranh findById(int id);

    void save(Tranh tranh);
}
