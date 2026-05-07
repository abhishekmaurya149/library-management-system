package com.example.lms.controller;

import com.example.lms.dto.BookDTO;
import com.example.lms.service.BookService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    // Add Book
    @PostMapping
    public BookDTO create(@Valid @RequestBody BookDTO dto) {
        return service.save(dto);
    }

    // Get All Books
    @GetMapping
    public List<BookDTO> getAll() {
        return service.getAll();
    }

    // Issue Book
    @PutMapping("/{id}/issue")
    public BookDTO issueBook(@PathVariable Long id) {
        return service.issueBook(id);
    }
}