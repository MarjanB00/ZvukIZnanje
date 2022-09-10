package com.project.zvukiznanje.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.zvukiznanje.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {

    private Integer id;
    private String name;
    @JsonIgnore
    private List<Users> users;
}
