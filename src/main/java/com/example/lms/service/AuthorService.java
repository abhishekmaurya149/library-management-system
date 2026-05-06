package com.example.lms.service;

import com.example.lms.entity.Author;
import com.example.lms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repo;

    public Author save(Author author) {
        return repo.save(author);
    }
}
