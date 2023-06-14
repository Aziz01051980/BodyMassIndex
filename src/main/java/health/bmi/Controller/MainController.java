package health.bmi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    @RequestMapping(value = "/bmiIndex", method = RequestMethod.GET)
    public String getCalculator(){
        return "bmiIndex";
    }
}
