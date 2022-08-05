package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class userController {

    @Autowired
    private UserService userService;


   // @PutMapping(value = "/api/addFavourites/{BookId}")
    //public ResponseEntity<Void> addBookToFavourites(@PathVariable Integer BookId,
      //                                              @RequestHeader Integer id){
       // userService.addToFavourites(BookId, id);
       // return null;
    //}
}
