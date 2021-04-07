package com.team.netch.feedback;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public String sendFeedback(@RequestBody Feedback feedback){
        feedbackService.saveFeedback(feedback);
        return "Спасибо за заказ обратной связи";
    }
}
