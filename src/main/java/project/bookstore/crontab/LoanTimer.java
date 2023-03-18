package project.bookstore.crontab;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import project.bookstore.model.Email;
import project.bookstore.model.WhoIsLate;
import project.bookstore.service.EmailSenderService;
import project.bookstore.service.WhoIsLateService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class LoanTimer {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private WhoIsLateService whoIsLateService;

    @Value("${spring.mail.username}")
    private String emailFrom;


    @Scheduled(cron = "0 0 21 * * *", zone = "Europe/Paris")
    public void sendHtmlMessageTest() throws MessagingException {

        List<WhoIsLate> findWhoIsLate =  whoIsLateService.findWhoIsLateDTO();

        for(WhoIsLate whoIsLate : findWhoIsLate){
            Email email = new Email();
            email.setTo(whoIsLate.getEmail());
            email.setFrom(emailFrom);
            email.setSubject("Books are late !");
            email.setTemplate("email-template.html");
            Map<String, Object> properties = new HashMap<>();
            properties.put("title", whoIsLate.getTitle());
            properties.put("ean13", whoIsLate.getEan13());
            properties.put("loanDate", whoIsLate.getLoanDate());
            properties.put("loanPeriod", whoIsLate.getLoanPeriod());
            properties.put("firstname", whoIsLate.getFirstname());
            properties.put("lastname", whoIsLate.getLastname());
            email.setProperties(properties);
            emailSenderService.sendHtmlMessage(email);
        }
    }

}
