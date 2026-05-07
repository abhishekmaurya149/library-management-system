package com.example.lms.service;

import com.example.lms.dto.BookDTO;
import com.example.lms.entity.Author;
import com.example.lms.entity.Book;
import com.example.lms.exception.ResourceNotFoundException;
import com.example.lms.repository.AuthorRepository;
import com.example.lms.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Add Book
    public BookDTO save(BookDTO dto) {

        log.info("Saving new book: {}", dto.getTitle());

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Author not found"));

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIssued(dto.isIssued());
        book.setAuthor(author);

        Book saved = bookRepository.save(book);

        return mapToDTO(saved);
    }

    // Get All Books
    public List<BookDTO> getAll() {

        log.info("Fetching all books");

        return bookRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Issue Book
    public BookDTO issueBook(Long id) {

        log.info("Issuing book with ID: {}", id);

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));

        book.setIssued(true);

        Book updated = bookRepository.save(book);

        return mapToDTO(updated);
    }

    // Convert Entity → DTO
    private BookDTO mapToDTO(Book book) {

        BookDTO dto = new BookDTO();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setIssued(book.isIssued());
        dto.setAuthorId(book.getAuthor().getId());
        dto.setAuthorName(book.getAuthor().getName());

        return dto;
    }
}