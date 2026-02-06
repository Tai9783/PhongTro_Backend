package com.phongtroapp.phongtro_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String userId;
    private String fullName;
    private String email;
    private String role;
    @Column(name = "password")
    private String pass;
    @Column(name = "phoneNumber")
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public User(String userId, String fullName, String email, String role, String pass, String phone) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.pass = pass;
        this.phone = phone;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User() {
    }
}
