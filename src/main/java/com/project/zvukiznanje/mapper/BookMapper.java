package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.entity.Books;
import com.project.zvukiznanje.entity.BooksWithRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Books convertToEntity(BookDTO bookDTO);

    BookDTO convertToDTO(Books books);
}
