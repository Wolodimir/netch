package com.team.netch.brief;

import com.team.netch.regLogAdminSecurity.email.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Primary
public class BriefEmailService implements EmailSender {

    //TODO change target method Primary

    private final static Logger LOGGER = LoggerFactory.getLogger(BriefEmailService.class);

    private final JavaMailSender mailSender;

    public BriefEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }




    @Override
    @Async
    public void send(String to, String email) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Есть что проверить на сайте");
            helper.setFrom("netchweb@gmail.com");
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
