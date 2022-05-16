package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.mapper.BookMapper;
import com.project.zvukiznanje.repository.booksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class searchController {

    @Autowired
    private booksRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping(value = "/api/search/{keyWord}")
    public ResponseEntity<HashSet<BookDTO>>searchBooks(@PathVariable(value = "keyWord")String keyWord){
        HashSet<BookDTO> BookSet  = bookMapper.convertHashToDTO(bookRepository.searchByKeyWord(keyWord));
        return new ResponseEntity<>(BookSet, HttpStatus.OK);
    }

}
