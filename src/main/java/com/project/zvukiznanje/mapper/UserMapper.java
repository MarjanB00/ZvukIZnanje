package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.users;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    users convertToEntity(UserDTO UserDTO);

    UserDTO convertToDTO(users user);
}
