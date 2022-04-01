package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<users, Integer> {


}
