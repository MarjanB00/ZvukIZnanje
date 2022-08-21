package com.project.zvukiznanje.security.controller;


import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.mapper.UserMapper;
import com.project.zvukiznanje.repository.UsersRepository;
import com.project.zvukiznanje.security.dto.UserLoginDTO;
import com.project.zvukiznanje.security.dto.UserWithTokenDTO;
import com.project.zvukiznanje.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authenticate")
public class AuthController {

    private final UserMapper userMapper;

    private final UsersRepository usersRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    @PostMapping(value = "login")
    ResponseEntity<UserWithTokenDTO>login(@RequestBody UserLoginDTO userLoginDTO){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userLoginDTO.getUsername(), userLoginDTO.getPassword()
        );

        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenProvider.createToken(authentication);

            UserDTO user = userMapper.convertToDTO(usersRepository.findByUsername(authentication.getName()));
            UserWithTokenDTO userWithToken = new UserWithTokenDTO(token, user);

            return new ResponseEntity<>(userWithToken, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
