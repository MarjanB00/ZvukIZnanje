package com.project.zvukiznanje.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookCreateDTO {

    private String name;
    private String author;
    private String description;
    private List<Integer> tagIds;
    private String image;

}
