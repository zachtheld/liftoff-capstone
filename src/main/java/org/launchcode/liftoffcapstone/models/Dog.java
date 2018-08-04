package org.launchcode.liftoffcapstone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String dogname;

    @NotNull
    private String breed;

    @NotNull
    private String vet;

    @NotNull
    private String vetphone;

    @NotNull
    private String diet;

    @NotNull
    private String meds;

    @ManyToOne
    private User user;

    public Dog() {}

    public Dog(String dogname, String breed, String vet, String vetphone, String diet, String meds) {
        this.dogname = dogname;
        this.breed = breed;
        this.vet = vet;
        this.vetphone = vetphone;
        this.diet = diet;
        this.meds = meds;
    }

    public int getId() {
        return id;
    }

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getVetphone() {
        return vetphone;
    }

    public void setVetphone(String vetphone) {
        this.vetphone = vetphone;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getMeds() {
        return meds;
    }

    public void setMeds(String meds) {
        this.meds = meds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
