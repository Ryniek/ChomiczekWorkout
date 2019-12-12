package pl.rynski.chomiczek_workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rynski.chomiczek_workout.model.User;
import pl.rynski.chomiczek_workout.service.AccountService;

@Controller
@RequestMapping("/")
public class LandingPageController {

    private AccountService accountService;

    @Autowired
    public LandingPageController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/secret")
    public String getSecret() {
        return "secret";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        User user = new User();
        model.addAttribute("userForm", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        accountService.addUserWithDefaultRole(user);
        return "redirect:/";
    }

    @GetMapping("/logmeout")
    public String logout() {
        return "logmeout";
    }
}
