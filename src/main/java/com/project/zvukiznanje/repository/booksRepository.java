package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface booksRepository extends JpaRepository<books, Integer>
{

}
