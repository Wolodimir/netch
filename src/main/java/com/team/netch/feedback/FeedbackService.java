package com.team.netch.feedback;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class FeedbackService {

    private final FeedbackRepo feedbackRepo;

    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }


    public String saveFeedback(Feedback feedback){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd", Locale.US);
        LocalDateTime strLocalDate = LocalDateTime.now();
        String localDate = strLocalDate.format(formatter);
        feedback.setCreatedAt(localDate);

        feedbackRepo.save(feedback);

        return "saved";
    }

    public List<Feedback> getAllActiveFeedback(){
        return feedbackRepo.findByActiveEquals(true);
    }


    public void offFeedbackById(Long id) {
        Feedback feedback = feedbackRepo.findById(id).get();
        feedback.setActive(false);
        feedbackRepo.save(feedback);
    }
}
