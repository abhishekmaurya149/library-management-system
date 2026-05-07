package com.example.lms.controller;

import com.example.lms.dto.AuthorDTO;
import com.example.lms.service.AuthorService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    public AuthorDTO create(@Valid @RequestBody AuthorDTO dto) {
        return service.save(dto);
    }
}