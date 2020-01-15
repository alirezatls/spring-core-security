package com.sample.corespringsecurity.controller;

public class UserResponse {
    private String reference;
    private String username;
    private String email;

    public UserResponse() {
    }

    public UserResponse(String reference, String username, String email) {
        this.reference = reference;
        this.username = username;
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
}
