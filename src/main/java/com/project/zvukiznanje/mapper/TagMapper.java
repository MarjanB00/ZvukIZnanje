package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.TagDTO;
import com.project.zvukiznanje.entity.Tags;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tags convertToEntity(TagDTO TagDTO);

    TagDTO convertToDTO(Tags tags);

    List<Tags> convertToEntityList(List<TagDTO> tags);

    List<TagDTO> convertToDTOList(List<Tags> allTags);
}
