package com.project.zvukiznanje.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class users {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @JsonBackReference
    @OneToMany(mappedBy ="user")
    private List<user_rating> UserRating = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "favourites",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private Set<books> favourites = new HashSet<>();

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public List<user_rating> getUserRating() {
        return UserRating;
    }

    public void setUserRating(List<user_rating> userRating) {
        UserRating = userRating;
    }

    public Set<books> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<books> favourites) {
        this.favourites = favourites;
    }
}
