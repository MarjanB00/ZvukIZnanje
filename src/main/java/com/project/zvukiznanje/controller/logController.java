package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.books;
import com.project.zvukiznanje.entity.users;
import com.project.zvukiznanje.mapper.UserMapper;
import com.project.zvukiznanje.repository.usersRepository;
import com.project.zvukiznanje.service.BookService;
import com.project.zvukiznanje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
public class logController {

    @Autowired
    private BookService bookService;

    @Autowired
    private usersRepository UserRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper UserMapper;

    @GetMapping(value = "/api/login/{email}/{password}")
    public ResponseEntity<UserDTO> login(@PathVariable(value = "email") String email,
                                         @PathVariable(value = "password") String password){
       UserDTO user = userService.findLoginUser(email, password);
       
       if (user!=null){return new ResponseEntity<>(user, HttpStatus.OK);}
       else {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }

    @PostMapping(value ="/api/register")
    public ResponseEntity<Void> register(@RequestBody UserDTO UserDTO){
        UserDTO.setDateOfCreation(LocalDate.now());
        users User = UserMapper.convertToEntity(UserDTO);
        UserRepository.save(User);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(value = "/api/home")
    public ResponseEntity<Page<books>>home(Pageable pageable){

        Page<books> BookPage = bookService.getBooksByPage(pageable);
        return new ResponseEntity<>(BookPage, HttpStatus.OK);
    }

}
