package com.example.validatesonginformation.service;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    Optional<T> findById(long id);

    void save(T object);

    void delete(Long id);
}
