package pl.rynski.chomiczek_workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.rynski.chomiczek_workout.account.model.ConfirmationToken;
import pl.rynski.chomiczek_workout.account.model.User;
import pl.rynski.chomiczek_workout.account.model.UserDto;
import pl.rynski.chomiczek_workout.account.repository.ConfirmationTokenRepository;
import pl.rynski.chomiczek_workout.account.repository.UserRepository;
import pl.rynski.chomiczek_workout.account.service.EmailSenderService;
import pl.rynski.chomiczek_workout.account.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private ConfirmationTokenRepository confirmationTokenRepository;
    private UserService userService;
    private EmailSenderService emailSenderService;
    private UserRepository userRepository;

    @Autowired
    public HomeController(ConfirmationTokenRepository confirmationTokenRepository, UserService userService, EmailSenderService emailSenderService, UserRepository userRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.userService = userService;
        this.emailSenderService = emailSenderService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @GetMapping("/secret")
    public String getSecret() {
        return "secret";
    }


    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, @Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        if(!bindingResult.hasErrors()) {
            user.setPassword(userDto.getPassword());
            userService.addUserWithDefaultRole(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Confirm your registration!");
            mailMessage.setFrom("chomiczekworkout@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            model.addAttribute("emailId", user.getEmail());

            return "successfulRegisteration";
        }
        else {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "errorRegister";
        }
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepository.findByUsername(token.getUser().getUsername());
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("errorRegister");
        }

        return modelAndView;
    }

    @GetMapping("/error")
    public String handleErrors() {
        return "errorRegister";
    }


    @GetMapping("/logmeout")
    public String logout() {
        return "logmeout";
    }

}
