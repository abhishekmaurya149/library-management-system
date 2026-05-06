
package com.example.lms.controller;

import com.example.lms.entity.Book;
import com.example.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    // Post -> Add Book
    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.save(book);
    }

    // GET -> All Books
    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    // GET -> Filter by Author
    @GetMapping("/author")
    public List<Book> getByAuthor(@RequestParam String name) {
        return service.getByAuthor(name);
    }

    // PUT -> Issue Book
    @PutMapping("/{id}/issue")
    public Book issueBook(@PathVariable Long id) {
        return service.updateIssueStatus(id);
    }


}
