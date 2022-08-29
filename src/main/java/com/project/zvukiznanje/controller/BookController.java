package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
public class BookController {

    @Autowired
    private BookService bookService;



    @Transactional
    @PostMapping(value = "/api/book/create")
    public ResponseEntity<Void> createNewBook(@RequestBody BookDTO bookDTO) {
        bookService.createNewBook(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Transactional
    @PutMapping(value = "/api/book/update")
    public  ResponseEntity<Void> updateBook(@RequestBody BookDTO bookDTO,
                                            @RequestHeader Integer id){
        bookService.update(bookDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/api/home/")
    public ResponseEntity<Page<BookDTO>> home(Pageable pageable) {
        Page<BookDTO> BookPage = bookService.getBooksByPage(pageable);
        return new ResponseEntity<>(BookPage, HttpStatus.OK);
    }
}

