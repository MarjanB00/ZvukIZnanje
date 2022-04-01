package com.project.zvukiznanje.repository;

import com.project.zvukiznanje.entity.audio_file;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface audio_fileRepository extends JpaRepository<audio_file, Integer>
{

}
