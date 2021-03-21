package com.team.netch.frontapi.textContent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TextContentRepo extends JpaRepository<TextContent, Long> {

}
