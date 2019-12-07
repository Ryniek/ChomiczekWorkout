package pl.rynski.chomiczek_workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.rynski.chomiczek_workout.model.User;
import pl.rynski.chomiczek_workout.service.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class HomeController {

    private Validator validator;
    private UserService userService;

    @Autowired
    public HomeController(Validator validator, UserService userService) {
        this.validator = validator;
        this.userService = userService;
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
    public String registerUser(@Valid @ModelAttribute User user) {
        Set<ConstraintViolation<User>> errors = validator.validate(user);
        if(errors.isEmpty()) {
            System.out.println("BRAK BLEDOW!!!!!!");
            userService.addUserWithDefaultRole(user);
            return "redirect:/";
        }
        else {
            System.out.println("BLEDY: ");
            errors.forEach(err -> System.out.println(err.getMessage()));
            return "redirect:/register";
        }
    }

    @GetMapping("/logmeout")
    public String logout() {
        return "logmeout";
    }
}
