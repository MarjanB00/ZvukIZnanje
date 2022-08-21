package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LogController {



    @Autowired
    private BookService bookService;



/*
    @Transactional
    @PostMapping(value = "/api/register")
    public ResponseEntity<Void> register(@RequestBody UserDTO userDTO) {
    userDTO.setDateOfCreation(LocalDate.now());
        Users user = UserMapper.convertToEntity(userDTO);
        UserRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }*/

    @GetMapping(value = "/api/home/")
    public ResponseEntity<Page<BookDTO>> home(Pageable pageable) {
        Page<BookDTO> BookPage = bookService.getBooksByPage(pageable);
        return new ResponseEntity<>(BookPage, HttpStatus.OK);
    }

}
