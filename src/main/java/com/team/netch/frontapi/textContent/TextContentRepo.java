package com.team.netch.frontapi.textContent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/*@Repository*/
public interface TextContentRepo extends JpaRepository<TextContent, Long> {
    List<TextContent> findByName(String name);
}
