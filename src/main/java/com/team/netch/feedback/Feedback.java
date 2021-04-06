package com.team.netch.feedback;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private Boolean active = true;

    public Feedback(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Feedback(String name, String email, String phone, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public Feedback(String name, String email, String phone, LocalDateTime createdAt, Boolean active) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.active = active;
    }

    public Feedback(Long id, String name, String email, String phone, LocalDateTime createdAt, Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.active = active;
    }

    public Feedback() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
