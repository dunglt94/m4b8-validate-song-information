package com.example.validatesonginformation.service;

import com.example.validatesonginformation.model.Song;
import com.example.validatesonginformation.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(long id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song object) {
        songRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}
