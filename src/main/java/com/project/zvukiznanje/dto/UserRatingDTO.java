package com.project.zvukiznanje.dto;

import com.project.zvukiznanje.entity.books;
import com.project.zvukiznanje.entity.users;

import javax.persistence.Column;
import java.util.List;

public class UserRatingDTO {

    private Integer Id;
    private String rating;
    private UserDTO user;
    private BookDTO book;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

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
