package com.juicyCore.eCatalog.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;



@Entity
@Table(name = "USERS")
public class UserModel {

//    public UserModel() {
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id;
    @Column(name = "USER_NAME", nullable = false)
    private String name;
    @Column(name = "USER_LASTNAME", nullable = false)
    private String lastname;
    @Column(name = "USER_PASSWORD",unique = true)
    private String password;
    @Column(name = "USER_USERNAME", unique = true)
    private String username;

    public UserModel( Long id,
                     @JsonProperty("name") String name,
                     @JsonProperty("lastname") String lastname,
                     @JsonProperty("password") String password,
                     @JsonProperty("username") String username) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
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
