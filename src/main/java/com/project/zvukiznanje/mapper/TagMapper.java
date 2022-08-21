package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.tagDTO;
import com.project.zvukiznanje.entity.Tags;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tags convertToEntity(tagDTO TagDTO);

    tagDTO convertToDTO(Tags tags);

    List<Tags> convertToEntityList(List<tagDTO> tags);
}
