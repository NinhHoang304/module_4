package com.example.validate_info_sing.repository;

import com.example.validate_info_sing.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
