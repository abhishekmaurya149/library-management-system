package com.example.lms.entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String title;
    private boolean issued;

     @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

     // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
