package com.project.zvukiznanje.security.auth;

import com.project.zvukiznanje.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomAuth {

    @Autowired
    private UsersRepository usersRepository;

    @Value("${auth-key}")
    private String authKey;

    public boolean hasPermission(String key){
        return key.equals(authKey);
    }

}
