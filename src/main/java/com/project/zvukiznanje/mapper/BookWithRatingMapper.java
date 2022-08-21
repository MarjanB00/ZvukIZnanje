package com.project.zvukiznanje.mapper;

import com.project.zvukiznanje.dto.BookDTO;
import com.project.zvukiznanje.entity.BooksWithRating;
import org.mapstruct.Mapper;

import java.util.HashSet;

@Mapper(componentModel = "spring")
public interface BookWithRatingMapper {



    BooksWithRating convertToEntity(BookDTO BookDTO);


    BookDTO convertToDTO(BooksWithRating books);


    HashSet<BookDTO> convertHashToDTO(HashSet<BooksWithRating> books);

   /* default BookDTO convertToBookDTO(Books book){
       BookDTO bookDTO = new BookDTO();
       bookDTO = convertToDTO(book);
       Set<UserRatingEntity> EveryUserRating = book.getUserRating();
       bookDTO.setUserRating(
            EveryUserRating.forEach(userRatingEntity -> {
                if (userRatingEntity.getBook().getId()==)
            });
       );
       return null;
    }*/

}
