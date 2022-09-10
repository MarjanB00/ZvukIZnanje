package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.TagDTO;
import com.project.zvukiznanje.entity.Tags;
import com.project.zvukiznanje.mapper.TagMapper;
import com.project.zvukiznanje.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;


@Service
public class TagService {

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private TagMapper tagMapper;

    public List<TagDTO> getAllTagsService() {
        List<TagDTO> tagDTOS = tagMapper.convertToDTOList(tagsRepository.getAllTags());
        return  tagDTOS;
    }

    public void createNewTag(String tag) throws InstanceAlreadyExistsException {
        if(tagsRepository.findByName(tag) == null){
            TagDTO newTag = new TagDTO();
            newTag.setName(tag);
            Tags tagEntity = tagMapper.convertToEntity(newTag);
            tagsRepository.save(tagEntity);
        }
        else {
            throw new InstanceAlreadyExistsException();
        }
    }
}
