package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface booksRepository extends JpaRepository<books, Integer> {

    @Query(value = "select * from books " +
            "where books.name LIKE %:keyWord% " +
            "or books.description LIKE %:keyWord%", nativeQuery = true)
    HashSet<books> searchByKeyWord(@Param("keyWord") String keyWord);


    @Query(value = "select Books from books Books")
    Page<books> getAllBooks(Pageable pageable);

    @Query(value = "select books.id as id, books.name as name, description, date_of_creation, text_file from books, book_tags, tags\n" +
            "where book_tags.book_id=books.id \n" +
            "and tags.id=book_tags.id\n" +
            "and tags.name LIKE :tag", nativeQuery = true)
    HashSet<books> searchByTag(String tag);
}
