package org.launchcode.liftoffcapstone.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Reviews {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 255)
    private String review;

    @ManyToOne
    private User user;

    public Reviews() {}


    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }


}
