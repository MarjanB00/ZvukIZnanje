package com.project.zvukiznanje.mapper;


import com.project.zvukiznanje.dto.UserRatingDTO;
import com.project.zvukiznanje.entity.user_rating;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserRatingMapper {

    user_rating convertToEntity(UserRatingDTO UserRatingDTO);

    UserRatingDTO convertToDTO(user_rating user_rating);

    Set<UserRatingDTO> convertToDTO(Set<user_rating> UserRatingSet);

}
