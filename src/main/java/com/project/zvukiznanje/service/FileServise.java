package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dao.FileDAO;
import com.project.zvukiznanje.entity.Books;
import com.project.zvukiznanje.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.management.InstanceNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class FileServise {


    @Value("${fs.base-url}")
    private String baseValue;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void uploadTextFile(MultipartFile textFile, Integer bookId) throws IOException {
        String fileName= new Date().getTime() + "_" + textFile.getOriginalFilename();

        String fullPath = baseValue + fileName;
        Path path = Paths.get(fullPath);
        Files.write(path, textFile.getBytes());
        bookRepository.addTextFile(fullPath, bookId);
    }

    public FileDAO downloadTextFile(Integer id) throws IOException, InstanceNotFoundException {
        Books book = bookRepository.findBookById(id);
        FileDAO TextFile = new FileDAO();
        if (book == null){
            throw new InstanceNotFoundException();
        }
        else {
           String  fullPath = book.getText_file();
           Path path = Paths.get(fullPath);
           TextFile.setFile(Files.readAllBytes(path));
           String name = book.getName() + ".txt";
            name.replaceAll("\\s","");
            TextFile.setName(name);
        }
        return TextFile;
    }

    @Transactional
    public void uploadAudioFile(MultipartFile audioFile, Integer bookId) throws IOException {
        String fileName= new Date().getTime() + "_" + audioFile.getOriginalFilename();

        String fullPath = baseValue + fileName;
        Path path = Paths.get(fullPath);
        Files.write(path, audioFile.getBytes());
        bookRepository.addAudioFile(fullPath, bookId);
    }

    public FileDAO downloadAudioFile(Integer id) throws IOException, InstanceNotFoundException {
        Books book = bookRepository.findBookById(id);
        FileDAO File = new FileDAO();
        if (book == null){
            throw new InstanceNotFoundException();
        }
        else {
            String  fullPath = book.getAudio_file();
            Path path = Paths.get(fullPath);
            File.setFile(Files.readAllBytes(path));
            String name = book.getName() + ".txt";
            name.replaceAll("\\s","");
            File.setName(name);
        }
        return File;
    }
}
