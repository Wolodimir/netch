package com.team.netch.progress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepo extends JpaRepository<Progress, Long> {
    List<Progress> findProgressByUserBriefStatusEquals(Boolean status);
}
