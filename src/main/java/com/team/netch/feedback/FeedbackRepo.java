package com.team.netch.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
    List<Feedback> findByActiveEquals(Boolean active);
}
