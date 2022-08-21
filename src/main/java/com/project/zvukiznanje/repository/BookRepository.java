package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {


    @Query(value = "select b.id, b.name, b.description, b.date_of_creation, b.text_file " +
            "from books b " +
            "where b.id = :id ", nativeQuery = true)
    Books findBookById(@Param("id") Integer id);

}
