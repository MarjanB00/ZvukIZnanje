package com.project.zvukiznanje.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users;

}
