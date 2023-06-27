package health.bmi.service;

import health.bmi.domain.BmiData;
import health.bmi.repository.BmiDataRepository;
import health.bmi.repository.NewBmiDataRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class BmiSendingService {

//    @Autowired
//    private BmiData bmiData;

    private BmiDataRepository bmiDataRepository;

    private JavaMailSender mailSender;

    private BmiData bmiData;

    public BmiSendingService(JavaMailSender mailSender, BmiData bmiData, BmiDataRepository bmiDataRepository) {
        this.mailSender = mailSender;
        this.bmiData = bmiData;
        this.bmiDataRepository = bmiDataRepository;
    }

    public void sendingMessage(String mail, double bmi, String name, double weight, double height){

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

        BmiData bmiData = new BmiData();
        bmiData.setPersonBMI(bmi);
        bmiData.setPersonName(name);
        bmiData.setPersonMail(mail);
        bmiData.setPersonWeight(weight);
        bmiData.setPersonHeight(height);
        bmiDataRepository.save(bmiData);

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(mail);
            mailMessage.setText(body);
            mailSender.send(mailMessage);
        }
        catch (Exception e){
            System.out.println("An error occur");
        }
    }

    public String getBmiByName(String yourName) {
        try {
            double bmi = bmiDataRepository.getBmiBypersonName(yourName);
            return "Your last last Bodu Mass Index was " + bmi;
        } catch (Exception e){
            return "An error occur, check your input again";
        }
    }
}
