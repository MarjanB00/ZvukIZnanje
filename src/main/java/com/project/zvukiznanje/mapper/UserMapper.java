package com.project.zvukiznanje.mapper;


import com.project.zvukiznanje.dto.UserDTO;
import com.project.zvukiznanje.entity.Users;
import com.project.zvukiznanje.security.dto.UserRegister;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    Users convertToEntityReg(UserRegister userRegister);

    Users convertToEntity(UserDTO UserDTO);

    UserDTO convertToDTO(Users user);


}
