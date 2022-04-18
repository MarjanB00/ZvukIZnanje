package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class logController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/login/{email}/{password}")
    public ResponseEntity<UserDTO> login(@PathVariable(value = "email") String email,
                                         @PathVariable(value = "password") String password){
      //  UserDTO user = userService.findLoginUser(email, password);
        //return new ResponseEntity<>(user, HttpStatus.OK);
        return null;
    }

}
