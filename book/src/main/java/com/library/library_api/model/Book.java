package com.library.library_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 200)
    @Column(nullable = false)
    private String title;

    @Size(min = 3, max = 20)
    private String isbn;

    @Min(-5000)
    @Max(2100)
    private Integer publishedYear;

    private boolean available = true;

    @NotNull
    @JoinColumn(name = "author_id", nullable = false)
    private Long authorId;

    public Book() {}

    public Book(String title, Long authorId, String isbn, Integer publishedYear,  boolean available) {
        this.title = title;
        this.authorId = authorId;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
