package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tagsRepository extends JpaRepository<tags, Integer>
{

}
