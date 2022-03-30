package com.project.zvukiznanje.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table
public class tags {

    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
    private List<books> books = new ArrayList<>();

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

    public List<com.project.zvukiznanje.entity.books> getBooks() {
        return books;
    }

    public void setBooks(List<com.project.zvukiznanje.entity.books> books) {
        this.books = books;
    }
}
