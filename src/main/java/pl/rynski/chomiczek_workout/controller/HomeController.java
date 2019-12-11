package pl.rynski.chomiczek_workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.rynski.chomiczek_workout.account.model.User;
import pl.rynski.chomiczek_workout.account.model.UserDto;
import pl.rynski.chomiczek_workout.account.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
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
        model.addAttribute("userForm", new User());
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid User user, @ModelAttribute @Valid UserDto userDto, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            user.setPassword(userDto.getPassword());
            userService.addUserWithDefaultRole(user);
            return "redirect:/";
        }
        else {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err));
            return "redirect:/error";
        }
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }


    @GetMapping("/logmeout")
    public String logout() {
        return "logmeout";
    }
}
