package com.project.zvukiznanje.entity;

import javax.persistence.*;

@Entity
@Table(name = "audio_file")
public class AudioFile {

    @Id
    @Column
    private Integer id;

    @Column
    private String destination;

    @Column
    private Integer Size;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Books book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public Books getBook() {
        return book;
    }


    public void setBook(Books book) {
        this.book = book;
    }
}
