package com.project.zvukiznanje.security.dto;

import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

    private String username;
    private String password;

}
