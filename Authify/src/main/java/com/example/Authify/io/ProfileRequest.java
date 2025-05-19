package com.example.Authify.io;

public class ProfileRequest {

    private String name;
    private String email;
    private String password;

    // ✅ All-Args Constructor
    public ProfileRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // ✅ Getters and Setters

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

    public String getPassword() {
        return password;
    }
}