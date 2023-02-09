package com.example.validate_info_sing.dto;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotBlank(message = "Không để trống")
    @Size(min = 1, max = 800, message = "Không quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*", message = "Không được chứa ký tự đặc biệt")
    private String name;
    @NotBlank(message = "Không để trống")
    @Size(min = 1, max = 300, message = "Không quá 300 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*", message = "Không được chứa ký tự đặc biệt")
    private String singer;
    @NotBlank(message = "Không để trống")
    @Size(min = 1, max = 1000, message = "Không quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9,]+", message = "Không được chứa ký tự đặc biệt trừ dấu phẩy")

    private String kind;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String kind) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
