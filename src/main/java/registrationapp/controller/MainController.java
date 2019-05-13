package registrationapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jnap
 */
@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping(value = {"/", "index"})
    public String root() {
        return "index";
    }

    @GetMapping(value = {"/login"})
    public String login(Model model) {
        return "login";
    }

    @GetMapping(value = {"/user"})
    public String userIndex() {
        return "user/index";
    }
}
