package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {


    @Query(value="select tag from Tags tag " +
            "where tag.id = :id")
    Tags findTagsById(Integer id);


    @Query(value="select * from tags " +
            "where name like :tag", nativeQuery=true)
    Tags findByName(String tag);


    @Query(value="select * from tags ", nativeQuery=true)
    List<Tags> getAllTags();
}
