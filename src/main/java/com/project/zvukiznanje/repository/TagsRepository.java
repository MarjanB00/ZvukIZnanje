package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {


    @Query(value="select * from tags\n" +
            "where name like :tag", nativeQuery=true)
    Tags findByName(String tag);
}
