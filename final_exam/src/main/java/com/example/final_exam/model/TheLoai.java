package com.example.final_exam.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenTheLoai;

    @OneToMany(mappedBy = "theLoai")
    private Set<Tranh> tranhSet;

    public TheLoai() {
    }

    public TheLoai(int id, String tenTheLoai, Set<Tranh> tranhSet) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.tranhSet = tranhSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public Set<Tranh> getTranhSet() {
        return tranhSet;
    }

    public void setTranhSet(Set<Tranh> tranhSet) {
        this.tranhSet = tranhSet;
    }
}
