package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.entity.books;
import org.mapstruct.Mapper;

import java.awt.print.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {


    books convertToEntity(BookDTO BookDTO);

    BookDTO convertToDTO(books books);


}
