package org.example.twitterspring.entity;

import org.example.twitterspring.enums.UserType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "date_create")
    private LocalDate dateCreate;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @OneToMany()
    private List<PostEntity> postEntities;

    public UserEntity() {
    }

    public UserEntity(Long id, String login, String password, LocalDate dateCreate, String name, String surname, LocalDate dateBirth, UserType userType) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.dateCreate = dateCreate;
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
