package com.team.netch.feedback;

import com.team.netch.brief.email.BriefEmailService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class FeedbackService {

    private final FeedbackRepo feedbackRepo;
    private final BriefEmailService briefEmailService;

    public FeedbackService(FeedbackRepo feedbackRepo, BriefEmailService briefEmailService) {
        this.feedbackRepo = feedbackRepo;
        this.briefEmailService = briefEmailService;
    }


    public String saveFeedback(Feedback feedback){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy", Locale.US);
        LocalDateTime strLocalDate = LocalDateTime.now().plusHours(4);
        String localDate = strLocalDate.format(formatter);
        feedback.setCreatedAt(localDate);

        feedbackRepo.save(feedback);

        //Send notification to IVAN
        briefEmailService.send("netchweb@gmail.com", "Оставили запрос на обратную связь.<br>"+
                "Номер: " + feedback.getPhone()+"<br>"+
                "Почта: " + feedback.getEmail()+"<br>"+
                "Имя: " + feedback.getName(),

                "Новый запрос на обратную связь");

       /* briefEmailService.send("netch-web@mail.ru", "Оставили запрос на обратную связь.\n"+
                        "Номер: " + feedback.getPhone()+"\n"+
                        "Почта: " + feedback.getEmail()+"\n"+
                        "Имя: " + feedback.getName(),

                "Новый запрос на обратную связь");
*/
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

    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }
}
