package com.team.netch.brief;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefRepo extends JpaRepository<Brief, Long> {
}
