package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.Books;
import com.project.zvukiznanje.entity.BooksWithRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface BooksWithRatingRepository extends JpaRepository<BooksWithRating, Integer> {




   /* @Query(value = "select * from books " +
            "where books.name LIKE %:keyWord% " +
            "or books.description LIKE %:keyWord%", nativeQuery = true)*/
   @Query(value = "select b.id, b.name, b.description, b.date_of_creation, b.text_file, b.image, b.audio_file, b.author, ur.rating " +
           "from books b " +
           "left  join (SELECT rating,  book_id from user_rating as ur where ur.user_id like :id) as ur " +
           "on ur.book_id=b.id " +
           "where b.name like %:keyWord% " +
           "or b.description like %:keyWord%", nativeQuery = true)
   HashSet<BooksWithRating> searchByKeyWord(@Param("keyWord") String keyWord, @Param("id") Integer id);


    @Query(value = "select books.id, name, description, date_of_creation, text_file, image, audio_file, author, ur.rating " +
            "from books " +
            " left join user_rating as ur on ur.book_id=books.id and ur.user_id like :id ",
            countQuery = "SELECT count(*) FROM books  " +
                    "left join user_rating as ur on ur.book_id=books.id " +
                    "and ur.user_id like :id ",
            nativeQuery = true)
    Page<BooksWithRating> getAllBooks(Pageable pageable, @Param("id") Integer id);



    @Query(value = "select * from " +
            "(select id, b.name, b.description, b.date_of_creation, b.text_file, b.image, b.audio_file, b.author, ur.rating " +
            "from books b " +
            "left  join (SELECT rating,  book_id from user_rating where user_id= :id) as ur " +
            "on ur.book_id=b.id) book_table, tags t, book_tags bt " +
            "where book_table.id=bt.book_id " +
            "and t.id = bt.tag_id " +
            "and t.name like :tag ", nativeQuery = true)
    HashSet<BooksWithRating> searchByTag(@Param("tag") String tag, @Param("id") Integer id);




  /*  @Query(value = "select * from books, user_rating " +
            "where books.id = :bookId " , nativeQuery= true)
    Books getBookById(@Param("bookId") Integer bookId); */
}
