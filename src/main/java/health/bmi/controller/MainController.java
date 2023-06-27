package health.bmi.controller;

import health.bmi.service.BmiSendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private BmiSendingService bmiSendingService;

    public MainController(BmiSendingService bmiSendingService) {
        this.bmiSendingService = bmiSendingService;
    }

    public void setBmiSendingService(BmiSendingService bmiSendingService) {
        this.bmiSendingService = bmiSendingService;
    }

    @RequestMapping(value = "/bmi", method = RequestMethod.GET)
    public String getCalculator(){
        return "bmiIndex";
    }

    @RequestMapping(value = "/sendEmail")
    @ResponseBody
    public String sendMail (
            @RequestParam("weight") double yourWeight,
            @RequestParam("height") double yourHeight,
            @RequestParam("name") String yourName,
            @RequestParam("mail") String yourMail
    ) {
        double bmi = yourWeight / (yourHeight * yourHeight);
        bmiSendingService.sendingMessage(yourMail, bmi, yourName, yourWeight, yourHeight);
        return null;
    }

    @RequestMapping(value = "/getBmi")
    @ResponseBody
    public Object getBmi (
            @RequestParam("nameForBmi") String yourName
    ) {
        return bmiSendingService.getBmiByName(yourName);
    }
}
