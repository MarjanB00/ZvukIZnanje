package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.tagDTO;
import com.project.zvukiznanje.entity.tags;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    tags convertToEntity(tagDTO TagDTO);

    tagDTO convertToDTO(tags tags);

    List<tags> convertToEntityList(List<tagDTO> tags);
}
