package com.springboot.userData.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_entries")
public class UserModel {

    @Id
    private String username;
    private String name;
    private String email;
    private String branch;
    private String password;


    // Getters setters
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
