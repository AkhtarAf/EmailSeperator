package sheridan.akhtaraf.emailseparator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeparatorController {
    public final Logger log = LoggerFactory.getLogger(SeparatorController.class);
    @GetMapping("/")
    public ModelAndView emailHome() {
        log.trace("Index Page");
        return new ModelAndView("index");
    }

    @GetMapping("/result")
    public ModelAndView emailPage(
        @RequestParam(defaultValue = "") String emailInput
    ){
        log.trace("Displaying Output");
        log.debug("emailInput = " + emailInput);
        if(emailInput != "" || !emailInput.isEmpty()) {
            return new ModelAndView("result", "emailData", emailInput);
        } else {
            return new ModelAndView("index", "error", "Invalid Email.");
        }
    }
}
