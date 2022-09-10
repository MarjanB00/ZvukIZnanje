package com.project.zvukiznanje.controller;


import com.project.zvukiznanje.dao.FileDAO;
import com.project.zvukiznanje.service.FileServise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.InstanceNotFoundException;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileServise fileServise;
    
    
//  ______________Text File Management_______________________________________________________________________________

    @PostMapping(value = "/textFile/upload")
    ResponseEntity<Void> createTextFile(@RequestParam("textFile") MultipartFile textFile,
                                        @RequestParam("bookId") Integer bookId) throws IOException {

        fileServise.uploadTextFile(textFile, bookId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/textFile/download/{id}")
    ResponseEntity<ByteArrayResource> getTextFile(@PathVariable("id") Integer id) throws IOException, InstanceNotFoundException {

        FileDAO TextFile = fileServise.downloadTextFile(id);
        ByteArrayResource byteArrayResource = new ByteArrayResource(TextFile.getFile());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("File-Name", TextFile.getName());

        return new ResponseEntity<>(byteArrayResource, httpHeaders, HttpStatus.OK);
    }

//________________Audio file Management_______________________________________________________________________________

    @PostMapping(value = "/audioFile/upload")
    ResponseEntity<Void> createAudioFile(@RequestParam("audioFile") MultipartFile audioFile,
                                         @RequestParam("bookId") Integer bookId) throws IOException {


        fileServise.uploadAudioFile(audioFile, bookId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/audioFile/download/{id}")
    ResponseEntity<ByteArrayResource> getAudioFile(@PathVariable("id") Integer id) throws IOException, InstanceNotFoundException {

        FileDAO File = fileServise.downloadAudioFile(id);
        ByteArrayResource byteArrayResource = new ByteArrayResource(File.getFile());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("File-Name", File.getName());

        return new ResponseEntity<>(byteArrayResource, httpHeaders, HttpStatus.OK);
    }
    
}
