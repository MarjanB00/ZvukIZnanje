package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {


    @Query(value="select user from Users user " +
            "where user.id = :id")
    Users findUserById(Integer id);



    @Query(value="select user from Users user " +
            "where user.email= :username")
    Users findByEmail(String username);




}
