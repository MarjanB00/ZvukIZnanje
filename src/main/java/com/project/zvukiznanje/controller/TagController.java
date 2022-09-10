package com.project.zvukiznanje.controller;

import com.project.zvukiznanje.dto.TagDTO;
import com.project.zvukiznanje.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.net.http.HttpResponse;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @PutMapping(value = "/api/tags/create")
    public ResponseEntity<Void> createTags(@RequestParam String tag) throws InstanceAlreadyExistsException {
        tagService.createNewTag(tag);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
