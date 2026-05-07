package com.example.lms.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthorDTO {

    private Long id;

    @NotBlank(message = "Author name is required")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}