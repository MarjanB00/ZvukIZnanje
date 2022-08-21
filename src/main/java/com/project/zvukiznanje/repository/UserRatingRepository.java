package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.UserRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRatingEntity, Integer> {

    @Query(value = "select rating from user_rating " +
            "where user_rating.book_id like :BookID " +
            " and user_rating.user_id like :UserID", nativeQuery = true)
    Integer findRatingByBookIdAndUserID(@Param("BookID") Integer BookId, @Param("UserID") Integer UserID);


    @Query(value = "select * from user_rating " +
            "where user_rating.user_id like :UserID", nativeQuery = true)
    Set<UserRatingEntity> findByUserID(@Param("UserID") Integer UserID);


    @Query(value = "select * from user_rating " +
            "where user_rating.user_id like :id", nativeQuery = true)
    UserRatingEntity findByIdOne(@Param("id") Integer id);
}

