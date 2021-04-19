package com.team.netch.brief;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BriefRepo extends JpaRepository<Brief, Long> {

    List<Brief> findByStatusEquals(Boolean status);

}
