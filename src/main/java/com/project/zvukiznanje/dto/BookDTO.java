package com.project.zvukiznanje.dto;


import java.time.LocalDate;
import java.util.List;

public class BookDTO {

    private Integer id;
    private String name;
    private String description;
    private LocalDate date_of_creation;
    private String text_file;
    private Integer rating;
    private List<tagDTO> tags;


    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<tagDTO> getTags() {
        return tags;
    }

    public void setTags(List<tagDTO> tags) {
        this.tags = tags;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(LocalDate date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public String getText_file() {
        return text_file;
    }

    public void setText_file(String text_file) {
        this.text_file = text_file;
    }

}
