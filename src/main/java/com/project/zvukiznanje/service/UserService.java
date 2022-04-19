package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.users;
import com.project.zvukiznanje.mapper.UserMapper;
import com.project.zvukiznanje.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private usersRepository UserRepository;

    @Autowired
    private UserMapper UserMapper;

    public users findLoginUser(String email, String password) {
        return UserRepository.findByEmailAndPassword(email, password);
    }

    public void save(UserDTO userDTO) {
        users User = UserMapper.convertToEntity(userDTO);
        UserRepository.save(User);

    }
}
