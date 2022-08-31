package com.project.zvukiznanje.service;

import com.project.zvukiznanje.dto.TagDTO;
import com.project.zvukiznanje.mapper.TagMapper;
import com.project.zvukiznanje.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
