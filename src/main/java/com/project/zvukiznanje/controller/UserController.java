package com.project.zvukiznanje.controller;
import com.project.zvukiznanje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PutMapping(value = "/api/user/addFavourites/{BookId}")
//  @PreAuthorize("@customAuth.hasPermission(#key)")
    public ResponseEntity<Void> addBookToFavourites(@PathVariable Integer BookId)
//                                                  @RequestHeader(value = "Authorize Key")String key
    {
       userService.addToFavourites(BookId);
       return new ResponseEntity<>(HttpStatus.OK);

   }

    @PutMapping(value = "/api/user/removeFromFavourites/{BookId}")
    public ResponseEntity<Void> removeBookFromFavourites(@PathVariable Integer BookId) {
        userService.removeFromFavourites(BookId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/api/user/rate")
    public ResponseEntity<Void> addBookRating(@RequestParam("BookId") Integer BookId,
                                              @RequestParam("Rating") Integer Rating){
        userService.rate(BookId, Rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
