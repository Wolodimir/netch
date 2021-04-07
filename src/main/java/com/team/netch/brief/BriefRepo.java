package com.team.netch.brief;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BriefRepo extends JpaRepository<Brief, Long> {

    List<Brief> findByStatusEquals(Boolean status);

}
