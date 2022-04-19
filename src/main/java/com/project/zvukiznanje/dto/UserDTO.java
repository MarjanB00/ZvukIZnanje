package com.project.zvukiznanje.dto;

import com.project.zvukiznanje.entity.books;
import com.project.zvukiznanje.entity.user_rating;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private Date dateOfCreation;
    private String password;
    private List<UserRatingDTO> UserRating;
    private Set<BookDTO> favourites;

    public Set<BookDTO> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<BookDTO> favourites) {
        this.favourites = favourites;
    }

    public List<UserRatingDTO> getUserRating() {
        return UserRating;
    }

    public void setUserRating(List<UserRatingDTO> userRating) {
        UserRating = userRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
