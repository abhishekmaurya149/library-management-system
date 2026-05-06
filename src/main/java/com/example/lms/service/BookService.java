package com.example.lms.service;

import com.example.lms.entity.Book;
import com.example.lms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public Book save(Book book) {
        return repo.save(book);
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public List<Book> getByAuthor(String name) {
        return repo.findByAuthorName(name);
    }

    public Book updateIssueStatus(Long id) {
        Book book = repo.findById(id).orElseThrow();
        book.setIssued(true);
        return repo.save(book);
    }
}