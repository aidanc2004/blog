package com.aidancarey2004.blog.post;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;
    private String author;
    private String title;
    private String body;
    private LocalDate date;
    private LocalDate updatedDate;

    public Post() {};

    public Post(Long id, String author, String title, String body, LocalDate date) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.body = body;
        this.date = date;
        this.updatedDate = null;
    }

    public Post(String author, String title, String body, LocalDate date) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.date = date;
        this.updatedDate = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
