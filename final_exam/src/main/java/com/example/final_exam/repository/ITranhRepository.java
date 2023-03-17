package com.example.final_exam.repository;

import com.example.final_exam.model.Tranh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITranhRepository extends JpaRepository<Tranh, Integer> {
    Page<Tranh> findTranhByTenTacPhamContainingIgnoreCaseAndTheLoai_TenTheLoaiContainingIgnoreCaseAndDeletedFalse(String tenTacPham, String tenTheLoai, Pageable pageable);
}
