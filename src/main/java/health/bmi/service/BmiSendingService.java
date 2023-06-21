package health.bmi.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class BmiSendingService {
    private JavaMailSender mailSender;

    public BmiSendingService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendingMessage(String mail, double bmi, String name){

        String body = null;

        if (bmi < 18.5) {
            body = "Dear " + name + ", According to the given data, your body mass index is " + bmi + ". You are in the underweight range";
        } else if (bmi > 18.5 && bmi < 25) {
            body = "Dear " + name + ", According to the given data, your body mass index is " + bmi + ". You have a healthy weight";
        } else if (bmi > 25 && bmi < 31) {
            body = "Dear " + name + ", According to the given data, your body mass index is " + bmi + ". You are in the overweight range";
        } else {
            body = "Dear " + name + ", According to the given data, your body mass index is " + bmi + ". You are in the obesity range";
        }
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(mail);
            mailMessage.setSubject("Body Mass IndexInformation");
            mailMessage.setText(body);
            mailMessage.setBcc("aziz.khalilov1980@gmail.com");
            mailSender.send(mailMessage);
        }
        catch (Exception e){
            System.out.println("An error occur");
        }
    }
}
