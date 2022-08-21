package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.entity.BooksWithRating;
import com.project.zvukiznanje.entity.Tags;
import com.project.zvukiznanje.entity.Users;
import com.project.zvukiznanje.mapper.BookWithRatingMapper;
import com.project.zvukiznanje.mapper.TagMapper;
import com.project.zvukiznanje.repository.BooksWithRatingRepository;
import com.project.zvukiznanje.repository.TagsRepository;
import com.project.zvukiznanje.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class BookService {

    private final UsersRepository usersRepository;

    private final TagsRepository tagsRepository;

    private final TagMapper tagMapper;

    private final BooksWithRatingRepository bookRepository;

    private final BookWithRatingMapper bookWithRatingMapper;


    public Integer getAuthenticatedUserId()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findByUsername(authentication.getName());
        return user.getId();

    }



    public Page<BookDTO> getBooksByPage(Pageable pageable) {
        Integer id = getAuthenticatedUserId();
        Page<BooksWithRating> page = bookRepository.getAllBooks(pageable , id);
        return page.map(bookWithRatingMapper::convertToDTO);
    }

    public HashSet<BookDTO> getBooksWithKeyWord(String keyWord) {
        Integer id = getAuthenticatedUserId();
        return bookWithRatingMapper.convertHashToDTO(bookRepository.searchByKeyWord(keyWord, id));
    }

    public HashSet<BookDTO> getBooksByTag(String tag) {
        Integer id = getAuthenticatedUserId();
        Tags tagEntity = tagsRepository.findByName(tag);
        HashSet<BookDTO> Books = bookWithRatingMapper.convertHashToDTO(bookRepository.searchByTag(tagEntity.getName(), id));

        return Books;
    }

    public void update(BookDTO bookDTO) {
        BooksWithRating book = bookRepository.getById(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setDescription(bookDTO.getDescription());
        book.setTags(tagMapper.convertToEntityList(bookDTO.getTags()));
        bookRepository.save(book);
    }


    public void createNewBook(BookDTO bookDTO) {
        bookDTO.setDate_of_creation(LocalDate.now());
        bookDTO.setText_file("path/file" + bookDTO.getName() + ".pdf");
        BooksWithRating book = bookWithRatingMapper.convertToEntity(bookDTO);
        bookRepository.save(book);
    }
}

