package com.pskwiercz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    private String description;

    public Review() {}

    public Review(long id, String rating, String description) {
        this.id = id;
        this.rating = rating;
        this.description = description;
    }

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
