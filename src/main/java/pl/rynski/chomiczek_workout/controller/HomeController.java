package pl.rynski.chomiczek_workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.rynski.chomiczek_workout.model.User;
import pl.rynski.chomiczek_workout.model.UserDto;
import pl.rynski.chomiczek_workout.service.UserService;

import javax.validation.Valid;
import javax.validation.Validator;

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
    public String registerUser(@ModelAttribute User user, @ModelAttribute @Valid UserDto userDto, BindingResult bindingResult) {

        if(!bindingResult.hasErrors()) {
            user.setPassword(userDto.getPassword());
            userService.addUserWithDefaultRole(user);
            return "redirect:/";
        }
        else {
            return "redirect:/register";
        }
    }

    @GetMapping("/logmeout")
    public String logout() {
        return "logmeout";
    }
}
