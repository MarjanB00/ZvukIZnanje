package com.project.zvukiznanje.mapper;


import com.project.zvukiznanje.dto.UserRatingDTO;
import com.project.zvukiznanje.entity.UserRatingEntity;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserRatingMapper {

    UserRatingEntity convertToEntity(UserRatingDTO UserRatingDTO);

    UserRatingDTO convertToDTO(UserRatingEntity UserRatingEntity);

    Set<UserRatingDTO> convertToDTO(Set<UserRatingEntity> userRatingEntitySet);


}
