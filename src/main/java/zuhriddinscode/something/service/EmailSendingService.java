package zuhriddinscode.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import zuhriddinscode.something.dto.MessageDTO;

@Service
public class EmailSendingService {

    //        @Value("${spring.mail.username}")
    private String fromAccount = "ibrohimovzuhriddin310@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendRegistration( String email, Integer profileId ){
        String subject = "Complete Registration";
        String body = "Registration Email. please click to link"+profileId;
        sendEmail (email,subject, body);
    }

    private String sendEmail(String email, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(fromAccount);
        msg.setTo(email);
        msg.setSubject(subject);
        msg.setText(body);
        javaMailSender.send(msg);
        return "Mail was send";
    }
}
