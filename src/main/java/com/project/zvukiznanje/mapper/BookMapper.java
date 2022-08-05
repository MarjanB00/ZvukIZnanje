package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.entity.books;
import org.mapstruct.Mapper;

import java.util.HashSet;

@Mapper(componentModel = "spring")
public interface BookMapper {


    books convertToEntity(BookDTO BookDTO);

    BookDTO convertToDTO(books books);

    HashSet<BookDTO> convertHashToDTO(HashSet<books> books);


}
