package com.project.zvukiznanje.controller;
import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;

@RestController
public class searchController {

    @Autowired
    private BookService bookService;


    @GetMapping(value = "/api/search/{keyWord}")
    public ResponseEntity<HashSet<BookDTO>>searchBooks(@PathVariable(value = "keyWord")String keyWord,
                                                       @RequestHeader Integer id){
        HashSet<BookDTO> BookSet  = bookService.getBooksWithKeyWord(keyWord, id);
        return new ResponseEntity<>(BookSet, HttpStatus.OK);
    }

    @GetMapping(value = "/api/search")
    public ResponseEntity<HashSet<BookDTO>>searchBooksByTag(@RequestParam String tag,
                                                            @RequestHeader Integer id){
        HashSet<BookDTO> BookTagSet  = bookService.getBooksByTag(tag, id);
        return new ResponseEntity<>(BookTagSet, HttpStatus.OK);
    }

}
