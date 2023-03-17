package com.example.final_exam.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "deleted = false")
public class Tranh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenTacPham;
    private String hoaSi;
    private int namVe;
    private String kichThuoc;
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "the_loai_id", referencedColumnName = "id")
    private TheLoai theLoai;

    public Tranh() {
    }

    public Tranh(int id, String tenTacPham, String hoaSi, int namVe, String kichThuoc, boolean deleted, TheLoai theLoai) {
        this.id = id;
        this.tenTacPham = tenTacPham;
        this.hoaSi = hoaSi;
        this.namVe = namVe;
        this.kichThuoc = kichThuoc;
        this.deleted = deleted;
        this.theLoai = theLoai;
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

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }
}
