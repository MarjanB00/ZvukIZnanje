package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {


    @Query(value = "select book from Books book " +
            "where book.id = :id")
    Books findBookById(@Param("id") Integer id);

    @Modifying
    @Query(value ="update Books book " +
            "set book.text_file = :fullPath " +
            "where book.id = :bookId")
    void addTextFile(String fullPath, Integer bookId);

    @Modifying
    @Query(value ="update Books book " +
            "set book.audio_file = :fullPath " +
            "where book.id = :bookId")
    void addAudioFile(String fullPath, Integer bookId);
}
