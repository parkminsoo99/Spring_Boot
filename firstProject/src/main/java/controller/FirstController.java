package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username","민수");
        return "greeting";
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","박민수");
        return "goodbye";
    }
}
