package com.aidancarey2004.blog.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class Post {
    @Id
    private Long id;
    private String title;
    private String body;
    private LocalDate date;

    public Post() {};

    public Post(Long id, String title, String body, LocalDate date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Post(String title, String body, LocalDate date) {
        this.title = title;
        this.body = body;
        this.date = date;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
