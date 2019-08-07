package com.project.koulwakel.entity;

import android.support.annotation.Size;

import java.util.Set;

public class SignUpForm {
    @Size(min = 3, max = 50)
    private String name;
    @Size(min = 3, max = 50)
    private String username;
    @Size(max = 60)
    private String email;
    @Size(max = 60)
    private String address;
    private Set<String> role;
    @Size(min = 6, max = 40)
    private String password;

    public SignUpForm(String name, String username, String email, String address, Set<String> role, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
