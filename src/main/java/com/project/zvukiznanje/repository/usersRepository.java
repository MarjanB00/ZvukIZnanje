package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usersRepository extends JpaRepository<users, Integer> {

    users findByEmail(String email);
}
