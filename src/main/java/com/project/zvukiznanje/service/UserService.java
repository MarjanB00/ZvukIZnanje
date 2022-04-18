package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.users;
import com.project.zvukiznanje.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private usersRepository UserRepository;

    public users findLoginUser(String email, String password) {
        users User = UserRepository.findByEmailAndPassword(email, password);
        return null;
    }
}
