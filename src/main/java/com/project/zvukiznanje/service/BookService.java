package com.project.zvukiznanje.service;

import com.project.zvukiznanje.configuration.configClass;
import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.entity.books;
import com.project.zvukiznanje.mapper.BookMapper;
import com.project.zvukiznanje.repository.booksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.function.Function;

@Service
public class BookService{


    @Autowired
    private configClass configClass;

    @Autowired
    private booksRepository BookRepository;

    @Autowired
    private BookMapper bookMapper;


    public Page<BookDTO> getBooksByPage(Pageable pageable, Integer id) {
       Page<books> page= BookRepository.getAllBooks(pageable);
        return page.map(entity -> {
            BookDTO dto = bookMapper.convertToDTO(entity);
            dto.setUserRating(
                configClass.SortUserRating(entity.getId(),id)
            );
            return dto;
        });
    }

    public HashSet<BookDTO> getBooksWithKeyWord(String keyWord, Integer id) {
       HashSet<BookDTO> Books = bookMapper.convertHashToDTO(BookRepository.searchByKeyWord(keyWord));
       Books.forEach(book -> book.setUserRating(configClass.SortUserRating(book.getId(), id)));
       return Books;
    }

    public HashSet<BookDTO> getBooksByTag(String tag, Integer id) {
        HashSet<BookDTO> Books  = bookMapper.convertHashToDTO(BookRepository.searchByTag(tag));
        Books.forEach(book -> book.setUserRating(configClass.SortUserRating(book.getId(), id)));
        return Books;
    }
}

