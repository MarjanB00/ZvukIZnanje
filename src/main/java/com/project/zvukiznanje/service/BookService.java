package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.BookCreateDTO;
import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.dto.TagDTO;
import com.project.zvukiznanje.entity.Books;
import com.project.zvukiznanje.entity.BooksWithRating;
import com.project.zvukiznanje.entity.Tags;
import com.project.zvukiznanje.entity.Users;
import com.project.zvukiznanje.mapper.BookMapper;
import com.project.zvukiznanje.mapper.BookWithRatingMapper;
import com.project.zvukiznanje.mapper.TagMapper;
import com.project.zvukiznanje.repository.BookRepository;
import com.project.zvukiznanje.repository.BooksWithRatingRepository;
import com.project.zvukiznanje.repository.TagsRepository;
import com.project.zvukiznanje.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;
    private final TagMapper tagMapper;
    private final BookRepository bookRepository;
    private final TagsRepository tagsRepository;
    private final UsersRepository usersRepository;
    private final BookWithRatingMapper bookWithRatingMapper;
    private final BooksWithRatingRepository booksWithRatingRepository;

    public Integer getAuthenticatedUserId()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findByEmail(authentication.getName());
        if (user==null){
            return null;
        }
        return user.getId();

    }



    public Page<BookDTO> getBooksByPage(Pageable pageable) {
        Integer id = getAuthenticatedUserId();
        Page<BooksWithRating> page = booksWithRatingRepository.getAllBooks(pageable , id);
        return page.map(bookWithRatingMapper::convertToDTO);
    }

    public HashSet<BookDTO> getBooksWithKeyWord(String keyWord) {
        Integer id = getAuthenticatedUserId();
        return bookWithRatingMapper.convertHashToDTO(booksWithRatingRepository.searchByKeyWord(keyWord, id));
    }

    public HashSet<BookDTO> getBooksByTag(String tag) {
        Integer id = getAuthenticatedUserId();
        Tags tagEntity = tagsRepository.findByName(tag);
        HashSet<BookDTO> Books = bookWithRatingMapper.convertHashToDTO(booksWithRatingRepository.searchByTag(tagEntity.getName(), id));

        return Books;
    }

    public void update(BookCreateDTO bookCreateDTO, Integer bookId) {
        Books book = bookRepository.findBookById(bookId);

        book.setName(bookCreateDTO.getName());
        book.setDescription(bookCreateDTO.getDescription());
        book.setAuthor(bookCreateDTO.getAuthor());
        book.setImage(bookCreateDTO.getImage());

        List<Tags> listOfTags = new ArrayList<>();
        for (Integer id : bookCreateDTO.getTagIds()) {
            listOfTags.add (tagsRepository.findTagsById(id));
        }
        book.setTags(listOfTags);
        bookRepository.save(book);
    }


    public void createNewBook(BookCreateDTO bookCreateDTO) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setName(bookCreateDTO.getName());
        bookDTO.setDescription(bookCreateDTO.getDescription());
        bookDTO.setAuthor(bookCreateDTO.getAuthor());
        bookDTO.setDate_of_creation(LocalDate.now());
        bookDTO.setImage(bookCreateDTO.getImage());

        Books book = bookMapper.convertToEntity(bookDTO);
        List<Tags> listOfTags = new ArrayList<>();
        for (Integer id : bookCreateDTO.getTagIds()) {
          listOfTags.add (tagsRepository.findTagsById(id));
        }
        book.setTags(listOfTags);
        bookRepository.save(book);
    }
}

