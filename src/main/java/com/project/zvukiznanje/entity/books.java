package com.project.zvukiznanje.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class books {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String date_of_creation;

    @Column
    private String text_file;

    @JsonIgnore
    @ManyToMany(mappedBy = "favourites")
    private Set<users> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "book_tags",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    private List<tags> tags = new ArrayList<>();

    @OneToOne
    @PrimaryKeyJoinColumn
    private audio_file audioFile;

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

    public String getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(String date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public String getText_file() {
        return text_file;
    }

    public void setText_file(String text_file) {
        this.text_file = text_file;
    }

    public Set<com.project.zvukiznanje.entity.users> getUsers() {
        return users;
    }

    public void setUsers(Set<com.project.zvukiznanje.entity.users> users) {
        this.users = users;
    }

    public List<com.project.zvukiznanje.entity.tags> getTags() {
        return tags;
    }

    public void setTags(List<com.project.zvukiznanje.entity.tags> tags) {
        this.tags = tags;
    }

    public audio_file getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(audio_file audioFile) {
        this.audioFile = audioFile;
    }
}