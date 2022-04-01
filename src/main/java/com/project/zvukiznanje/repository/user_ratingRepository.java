package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.user_rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_ratingRepository extends JpaRepository<user_rating, Integer>
{

}
