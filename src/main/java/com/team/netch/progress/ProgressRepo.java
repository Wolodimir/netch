package com.team.netch.progress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepo extends JpaRepository<Progress, Long> {
}
