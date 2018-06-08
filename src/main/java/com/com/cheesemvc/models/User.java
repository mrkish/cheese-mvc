package com.com.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private static int idCounter = 1;
    private int userId;

    @NotNull
    @Size(min=5, max=15)
    private String username;

    @NotNull
    @Size(min=1)
    private String password;

    @NotNull(message="Passwords don't match.")
    private String verifyPassword;

    @Email
    private String email;
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

    private void checkPassword(String password, String verifyPassword) {
        if (password != null && verifyPassword != null) {
            if (!password.equals(verifyPassword)) {
                this.verifyPassword = null;
            }
        }
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
        this.checkPassword(this.password, this.verifyPassword);
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        this.checkPassword(this.password, this.verifyPassword);
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
}
