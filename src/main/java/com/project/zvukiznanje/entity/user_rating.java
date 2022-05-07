package com.project.zvukiznanje.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_rating")
public class user_rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;

    @Column
    private String rating;

    /*
    @ManyToOne
    @JoinColumn(name = "user_id")
    private users user;


    @ManyToOne
    @JoinColumn(name = "book_id")
    private books book;

    public books getBook() {
        return book;
    }

    public void setBook(books book) {
        this.book = book;
    }
    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }
*/
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
