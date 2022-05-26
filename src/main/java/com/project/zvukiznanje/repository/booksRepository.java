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
public interface booksRepository extends JpaRepository<books, Integer>
{

    @Query(value = "select * from books " +
            "where books.name LIKE %:keyWord% " +
            "or books.description LIKE %:keyWord%", nativeQuery = true)
    HashSet<books> searchByKeyWord(@Param("keyWord") String keyWord);


    @Query(value="select Books from books Books")
    Page<books> getAllBooks(Pageable pageable);

}
