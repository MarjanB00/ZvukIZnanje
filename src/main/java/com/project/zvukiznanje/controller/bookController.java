package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.entity.books;
import com.project.zvukiznanje.mapper.BookMapper;
import com.project.zvukiznanje.repository.booksRepository;
import com.project.zvukiznanje.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
public class bookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private booksRepository booksRepository;

    @Transactional
    @PostMapping(value = "/api/create")
    public ResponseEntity<Void> createNewBook(@RequestBody BookDTO bookDTO,
                                              @RequestHeader Integer id) {
        bookDTO.setDate_of_creation(LocalDate.now());
        bookDTO.setText_file("path/file" + bookDTO.getName() + ".pdf");
        books book = bookMapper.convertToEntity(bookDTO);
        booksRepository.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Transactional
    @PutMapping(value = "/api/update")
    public  ResponseEntity<Void> updateBook(@RequestBody BookDTO bookDTO,
                                            @RequestHeader Integer id){
        bookService.update(bookDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
