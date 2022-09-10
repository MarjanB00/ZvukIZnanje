package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.Books;
import com.project.zvukiznanje.entity.UserRatingEntity;
import com.project.zvukiznanje.entity.Users;
import com.project.zvukiznanje.mapper.UserMapper;
import com.project.zvukiznanje.repository.BookRepository;
import com.project.zvukiznanje.repository.UserRatingRepository;
import com.project.zvukiznanje.repository.UsersRepository;
import com.project.zvukiznanje.security.dto.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRatingRepository userRatingRepository;

    @Autowired
    private UsersRepository UserRepository;

    @Autowired
    private UserMapper userMapper;


    public Integer getAuthenticatedUserId()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = UserRepository.findByEmail(authentication.getName());
        return user.getId();

    }

    public void save(UserDTO userDTO) {
        Users User = userMapper.convertToEntity(userDTO);
        UserRepository.save(User);

    }


     public void addToFavourites(Integer bookId) {
        //Get user id
        Integer id = getAuthenticatedUserId();
        //Get  user by id and book by bookId
        Users user = UserRepository.findUserById(id);
        Books book = bookRepository.findBookById(bookId);
        //Add book to favourites
         Set<Books> bookSet = user.getFavourites();


         bookSet.add(book);
        //Save new book to favourites
         user.setFavourites(bookSet);
         UserRepository.save(user);
    }


    public UserRatingEntity getRating(Integer id) {
       return userRatingRepository.findByIdOne(id);
    }


    public void rate(Integer bookId, Integer rating) {
        Integer id = getAuthenticatedUserId();

        UserRatingEntity userRating = new UserRatingEntity();
        userRating.setUserID(id);
        userRating.setBook(bookRepository.getById(bookId));
        userRating.setRating(rating);
        userRatingRepository.save(userRating);

    }

    public void register(UserRegister userRegister) {

            String encodedPassword = passwordEncoder.encode(userRegister.getPassword());

            userRegister.setDateOfCreation(LocalDate.now());

            Users user = userMapper.convertToEntityReg(userRegister);
            user.setPassword(encodedPassword);


            UserRepository.save(user);

    }

    public void removeFromFavourites(Integer bookId) {

        Integer id = getAuthenticatedUserId();
        //Get  user by id and book by bookId
        Users user = UserRepository.findUserById(id);
        Books book = bookRepository.findBookById(bookId);
        //Add book to favourites
        Set<Books> bookSet = user.getFavourites();


        bookSet.remove(book);
        //Save new book to favourites
        user.setFavourites(bookSet);
        UserRepository.save(user);
    }
}