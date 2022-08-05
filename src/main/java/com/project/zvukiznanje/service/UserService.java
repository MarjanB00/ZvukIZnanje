package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.dto.UserRatingDTO;
import com.project.zvukiznanje.entity.users;
import com.project.zvukiznanje.mapper.UserMapper;
import com.project.zvukiznanje.mapper.UserRatingMapper;
import com.project.zvukiznanje.repository.userRatingRepository;
import com.project.zvukiznanje.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {



    @Autowired
    private UserRatingMapper userRatingMapper;

    @Autowired
    private userRatingRepository UserRatingRepository;

    @Autowired
    private usersRepository UserRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO findLoginUser(String email, String password) {
        users user = UserRepository.findByEmailAndPassword(email, password);
        UserDTO userDTO = userMapper.convertToDTO(user);
        Set<BookDTO> favorites = userDTO.getFavourites();
        Set<UserRatingDTO> AllRatingForUser = userRatingMapper.convertToDTO(UserRatingRepository.findByUserID(userDTO.getId()));
        favorites.forEach((bookDTO) -> AllRatingForUser.forEach(userRatingDTO -> {
                    if (userRatingDTO.getBookID().equals(bookDTO.getId())) {
                        bookDTO.setUserRating(userRatingDTO.getRating());
                    }
                })
        );
        userDTO.setFavourites(favorites);
        return userDTO;
    }

    public void save(UserDTO userDTO) {
        users User = userMapper.convertToEntity(userDTO);
        UserRepository.save(User);

    }

   // public void addToFavourites(Integer bookId, Integer id) {
     //  users user = UserRepository.getById(id);
       //user.setFavourites(book);
    //}
}
