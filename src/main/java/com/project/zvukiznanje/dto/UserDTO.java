package com.project.zvukiznanje.dto;

import java.time.LocalDate;
import java.util.Set;

public class UserDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfCreation;
    private String password;
    private Set<BookDTO> favourites;


    public Set<BookDTO> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<BookDTO> favourites) {
        this.favourites = favourites;
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

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
