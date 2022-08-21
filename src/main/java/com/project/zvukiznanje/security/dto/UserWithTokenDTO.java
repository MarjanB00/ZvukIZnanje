package com.project.zvukiznanje.security.dto;

import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UserWithTokenDTO {

    private String token;
    private UserDTO user;
}
