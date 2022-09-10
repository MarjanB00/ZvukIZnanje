package com.project.zvukiznanje.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private Integer id;
    private String name;
    private String description;
    private LocalDate date_of_creation;
    private String text_file;
    private Integer rating;
    private List<TagDTO> tags;
    private String author;
    private String image;
    private String audio_file;



}
