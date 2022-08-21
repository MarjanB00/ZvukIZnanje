package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.AudioFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioFileRepository extends JpaRepository<AudioFile, Integer> {


}
