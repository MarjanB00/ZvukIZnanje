package com.project.zvukiznanje.security.dto;

import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

    private String email;
    private String password;

}
