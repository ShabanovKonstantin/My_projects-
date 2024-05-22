package org.example.twitterspring.dto.response.post_dto;

import java.time.LocalDate;
import java.util.List;

public class PostResponseDto {

    private Long id;

    private String them;

    private String text;

    private LocalDate dateCreate;

    private Long author;

    private List<String> tags;

    public PostResponseDto() {
    }

    public PostResponseDto(Long id, String them, String text, LocalDate dateCreate, Long author, List<String> tags) {
        this.id = id;
        this.them = them;
        this.text = text;
        this.dateCreate = dateCreate;
        this.author = author;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
