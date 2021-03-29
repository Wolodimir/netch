package com.team.netch.frontapi.imageContent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageContentRepo extends JpaRepository<ImageContent, Long> {
}
