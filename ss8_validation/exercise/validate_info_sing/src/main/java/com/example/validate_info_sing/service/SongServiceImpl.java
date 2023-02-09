package com.example.validate_info_sing.service;

import com.example.validate_info_sing.model.Song;
import com.example.validate_info_sing.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    private ISongRepository repository;
    @Override
    public List<Song> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Song findById(int id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        this.repository.save(song);
    }
}
