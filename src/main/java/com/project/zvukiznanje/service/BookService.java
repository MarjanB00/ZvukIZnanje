package com.project.zvukiznanje.service;

import com.project.zvukiznanje.entity.books;
import com.project.zvukiznanje.mapper.BookMapper;
import com.project.zvukiznanje.repository.booksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private booksRepository BookRepository;

    @Autowired
    private BookMapper bookMapper;

    public Page<books> getBooksByPage(Pageable pageable) {
        return BookRepository.getAllBooks(pageable);
    }
}
