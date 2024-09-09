package com.example.overwork.entiry;

import jakarta.persistence.*;

@Entity
@Table(name = "Member2")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="grade")
    private Grade grade;

    public Member(String username, String password, Long id, Grade grade) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.grade = grade;
    }

    public boolean checkLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public Member() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
