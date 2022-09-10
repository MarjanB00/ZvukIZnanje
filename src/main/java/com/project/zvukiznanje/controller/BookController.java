package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookCreateDTO;
import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookService bookService;



    @Transactional
    @PostMapping(value = "/api/book/create")
    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateDTO bookCreateDTO) {
        log.info(bookCreateDTO.toString());
        bookService.createNewBook(bookCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Transactional
    @PutMapping(value = "/api/book/update")
    public  ResponseEntity<Void> updateBook(@RequestBody BookCreateDTO bookDTO,
                                            @RequestParam Integer bookId){
        bookService.update(bookDTO, bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/api/home/")
    public ResponseEntity<Page<BookDTO>> home(Pageable pageable) {
        Page<BookDTO> BookPage = bookService.getBooksByPage(pageable);
        return new ResponseEntity<>(BookPage, HttpStatus.OK);
    }
}

