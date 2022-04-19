package com.project.zvukiznanje.dto;

import javax.persistence.Column;

public class UserRatingDTO {

    private Integer Id;
    private String rating;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
