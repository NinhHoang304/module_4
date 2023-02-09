package com.example.validate_info_sing.service;

import com.example.validate_info_sing.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findById(int id);

    void save(Song song);
}
