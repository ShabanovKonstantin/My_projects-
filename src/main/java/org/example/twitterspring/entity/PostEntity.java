package org.example.twitterspring.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "them")
    private String them;

    @Column(name = "text")
    private String text;

    @Column(name = "date_create")
    private LocalDate dateCreate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity author;

    @Column(name = "tags")
    //@Convert(converter = TagsConverter.class)
    @Type(type = "org.example.twitterspring.coverters.hibernate.TagsType")
    private List<String> tags;

    public PostEntity() {
    }

    public PostEntity(Long id, String them, String text, LocalDate dateCreate, UserEntity author) {
        this.id = id;
        this.them = them;
        this.text = text;
        this.dateCreate = dateCreate;
        this.author = author;
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

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
