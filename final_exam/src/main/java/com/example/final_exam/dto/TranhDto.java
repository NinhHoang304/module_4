package com.example.final_exam.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TranhDto {
    private int id;
    private String tenTacPham;
    private String hoaSi;
    private int namVe;
    private String kichThuoc;
    private boolean deleted;

    public TranhDto() {
    }

    public TranhDto(int id, String tenTacPham, String hoaSi, int namVe, String kichThuoc, boolean deleted) {
        this.id = id;
        this.tenTacPham = tenTacPham;
        this.hoaSi = hoaSi;
        this.namVe = namVe;
        this.kichThuoc = kichThuoc;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTacPham() {
        return tenTacPham;
    }

    public void setTenTacPham(String tenTacPham) {
        this.tenTacPham = tenTacPham;
    }

    public String getHoaSi() {
        return hoaSi;
    }

    public void setHoaSi(String hoaSi) {
        this.hoaSi = hoaSi;
    }

    public int getNamVe() {
        return namVe;
    }

    public void setNamVe(int namVe) {
        this.namVe = namVe;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
