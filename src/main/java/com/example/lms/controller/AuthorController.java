package com.example.lms.controller;

import com.example.lms.entity.Author;
import com.example.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

     @PostMapping
    public Author create(@RequestBody Author author) {
        return service.save(author);
    }
}
