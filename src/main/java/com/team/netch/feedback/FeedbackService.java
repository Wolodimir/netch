package com.team.netch.feedback;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepo feedbackRepo;

    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }


    public String saveFeedback(Feedback feedback){
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
