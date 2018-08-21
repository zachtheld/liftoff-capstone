package org.launchcode.liftoffcapstone.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Email(message = "Email Address Invalid")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password Must Be 6 Characters Long")
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Dog> dogs = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserInfo> userInfos = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Reviews> reviews = new ArrayList<>();

    public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Dog> getDogs() { return dogs; }

    public List<UserInfo> getUserInfos() { return userInfos; }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public int getId() {
        return id;
    }
}
