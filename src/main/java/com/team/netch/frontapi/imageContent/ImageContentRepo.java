package com.team.netch.frontapi.imageContent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageContentRepo extends JpaRepository<ImageContent, Long> {
    List<ImageContent> findByName(String name);
}
