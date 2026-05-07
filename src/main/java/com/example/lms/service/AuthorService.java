package com.example.lms.service;

import com.example.lms.dto.AuthorDTO;
import com.example.lms.entity.Author;
import com.example.lms.repository.AuthorRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public AuthorDTO save(AuthorDTO dto) {

        log.info("Saving author: {}", dto.getName());

        Author author = new Author();
        author.setName(dto.getName());

        Author saved = repository.save(author);

        AuthorDTO response = new AuthorDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());

        return response;
    }
}