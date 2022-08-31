package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.dto.TagDTO;
import com.project.zvukiznanje.dto.UserRatingDTO;
import com.project.zvukiznanje.mapper.UserRatingMapper;
import com.project.zvukiznanje.service.BookService;
import com.project.zvukiznanje.service.TagService;
import com.project.zvukiznanje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;


@RestController
public class SearchController {

    @Autowired
    private TagService tagService;

    @Autowired
    private UserRatingMapper userRatingMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;


    @GetMapping(value = "/api/search/{keyWord}")
    public ResponseEntity<HashSet<BookDTO>> searchBooksByKeyword(@PathVariable(value = "keyWord") String keyWord) {
        HashSet<BookDTO> BookSet = bookService.getBooksWithKeyWord(keyWord);
        return new ResponseEntity<>(BookSet, HttpStatus.OK);
    }

    @GetMapping(value = "/api/search")
    public ResponseEntity<HashSet<BookDTO>> searchBooksByTag(@RequestParam String tag) {
        HashSet<BookDTO> BookTagSet = bookService.getBooksByTag(tag);
        return new ResponseEntity<>(BookTagSet, HttpStatus.OK);
    }
    @GetMapping(value = "api/search/One")
    public ResponseEntity<UserRatingDTO> returnUserRating(@RequestParam Integer id){
        UserRatingDTO URDTO = userRatingMapper.convertToDTO(userService.getRating(id));
        return new ResponseEntity<>(URDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/search/tags")
    public ResponseEntity<List<TagDTO>> getAllTags(){
      List<TagDTO> tagDTOS = tagService.getAllTagsService();
      return  new ResponseEntity<>(tagDTOS, HttpStatus.OK);
    }
}
