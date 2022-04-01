package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.UserLoginDTO;
import com.project.zvukiznanje.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class logController {

    @Autowired
    private LogService logService;



}
