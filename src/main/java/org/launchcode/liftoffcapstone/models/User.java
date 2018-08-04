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

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Email(message = "Email Address Invalid")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password Must Be 6 Characters Long")
    private String password;

    @NotNull
    private String phone;


    @NotNull
    private String address;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Dog> dogs = new ArrayList<>();

    //public User(String username, String email, String password) {
      //  this.username = username;
        //this.email = email;
        //this.password = password;

    public User() {
    }

    public String getName(){
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public List<Dog> getDogs() { return dogs; }

    public int getId() {
        return id;
    }
}
