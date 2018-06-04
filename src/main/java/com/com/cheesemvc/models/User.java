package com.com.cheesemvc.models;

import java.util.Date;

public class User {

    private static int idCounter = 1;
    private int userId;
    private String username;
    private String email;
    private String password;
    private Date joined;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        this.userId = idCounter;
        this.joined = new Date();
        idCounter++;
    }

    public int getId() {
        return this.userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
}
