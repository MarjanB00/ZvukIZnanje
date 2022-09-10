package com.project.zvukiznanje.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ehcache.core.spi.service.ServiceFactory;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserRegister {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfCreation;
}
