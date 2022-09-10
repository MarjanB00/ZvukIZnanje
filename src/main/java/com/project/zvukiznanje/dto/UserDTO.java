package com.project.zvukiznanje.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private LocalDate dateOfCreation;
    @JsonIgnore
    private String password;
    private Set<BookDTO> favourites;
    private List<RoleDTO> roles;



}
