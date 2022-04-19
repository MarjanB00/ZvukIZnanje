package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.UserRatingDTO;
import com.project.zvukiznanje.entity.user_rating;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserRatingMapper {

    UserRatingDTO convertToDTO(user_rating user_rating);

    user_rating convertToEntity(UserRatingDTO UserRatingDTO);

}
