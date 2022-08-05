package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<users, Integer> {

    users findByEmailAndPassword(String email, String Password);

}
