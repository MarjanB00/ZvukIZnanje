package com.project.zvukiznanje.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class users {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column
    private String password;

    /*
    @OneToMany(mappedBy ="user")
    private List<user_rating> UserRating = new ArrayList<>();
*/
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "favourites",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private Set<books> favourites = new HashSet<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    /*
    public List<user_rating> getUserRating() {
        return UserRating;
    }

    public void setUserRating(List<user_rating> userRating) {
        UserRating = userRating;
    }
    */


    public Set<books> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<books> favourites) {
        this.favourites = favourites;
    }

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", password='" + password + '\'' +
               // ", UserRating=" + UserRating +
                ", favourites=" + favourites +
                '}';
    }
}
