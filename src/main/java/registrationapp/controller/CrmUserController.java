package registrationapp.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import registrationapp.models.CrmUser;
import registrationapp.models.User;
import registrationapp.service.UserService;

/**
 *
 * @author jnap
 */
@Controller
@RequestMapping("/registration")
public class CrmUserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public CrmUser crmUser() {
        return new CrmUser();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid CrmUser crmUser,
            BindingResult result) {

        User existing = userService.findByEmail(crmUser.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(crmUser);
        return "redirect:/registration?success";
    }

}
