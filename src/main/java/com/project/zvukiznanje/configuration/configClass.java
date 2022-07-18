package com.project.zvukiznanje.configuration;

import com.project.zvukiznanje.dto.UserRatingDTO;
import com.project.zvukiznanje.mapper.UserRatingMapper;
import com.project.zvukiznanje.repository.userRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Configuration
public class configClass {

    @Autowired
    private UserRatingMapper userRatingMapper;

    @Autowired
    private userRatingRepository UserRatingRepository;



    public Integer SortUserRating(Integer BookId, Integer UserID){
        Set<UserRatingDTO> EveryRatingForUser = userRatingMapper.convertToDTO(UserRatingRepository.findByUserID(UserID));
        AtomicReference<Integer> UserRating = new AtomicReference<>();
        EveryRatingForUser.forEach(userRatingDTO -> {
                    if (userRatingDTO.getBookID().equals(BookId)) {
                        UserRating.set(userRatingDTO.getRating());
                    }
                }
        );
        return UserRating.get();
    }
}
