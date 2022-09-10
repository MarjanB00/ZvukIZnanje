package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.RoleDTO;
import com.project.zvukiznanje.entity.Roles;
import org.mapstruct.Mapper;

import javax.management.relation.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Roles convertToEntity(RoleDTO roleDTO);

    RoleDTO convertToDTO(Roles roles);
}
