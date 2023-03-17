package com.example.final_exam.service;

import com.example.final_exam.model.Tranh;
import com.example.final_exam.repository.ITranhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TranhServiceImpl implements ITranhService{
    @Autowired
    private ITranhRepository tranhRepository;
    @Override
    public Page<Tranh> findTranh(String tenTacPham, String tenTheLoai, Pageable pageable) {
        return this.tranhRepository.findTranhByTenTacPhamContainingIgnoreCaseAndTheLoai_TenTheLoaiContainingIgnoreCaseAndDeletedFalse(tenTacPham, tenTheLoai, pageable);
    }

    @Override
    public Tranh findById(int id) {
        return this.tranhRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Tranh tranh) {
        this.tranhRepository.save(tranh);
    }
}
