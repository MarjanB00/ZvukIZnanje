package com.project.zvukiznanje.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Immutable
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="books")
public class BooksWithRating{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "date_of_creation")
    private java.sql.Date date_of_creation;

    @Column
    private String text_file;

    @Column
    private String image;

    @Column
    private String audio_file;

    @Column
    private String author;

    @JsonBackReference
    @ManyToMany(mappedBy = "favourites")
    private Set<Users> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "book_tags",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    private List<Tags> tags = new ArrayList<>();




    @Column
    private Integer rating;


}