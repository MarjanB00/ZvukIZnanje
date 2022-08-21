package com.project.zvukiznanje.mapper;


import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.Users;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {


    Users convertToEntity(UserDTO UserDTO);

    UserDTO convertToDTO(Users user);


}
