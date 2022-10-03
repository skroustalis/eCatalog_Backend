package com.juicyCore.eCatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    public UserDTO() {
    }

    private String name;
    private String lastname;
    private String password;
    private String username;

    public UserDTO(
                      @JsonProperty("name") String name,
                      @JsonProperty("lastname") String lastname,
                      @JsonProperty("password") String password,
                      @JsonProperty("username") String username) {

        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}