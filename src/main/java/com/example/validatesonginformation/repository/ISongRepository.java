package com.example.validatesonginformation.repository;

import com.example.validatesonginformation.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends CrudRepository<Song, Long> {
}
