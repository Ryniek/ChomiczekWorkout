package pl.rynski.chomiczek_workout.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rynski.chomiczek_workout.profile.modelDto.ErrorMessage;
import pl.rynski.chomiczek_workout.profile.modelDto.ProfileDto;
import pl.rynski.chomiczek_workout.profile.service.ProfileService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("profile", profileService.getProfile());
        return "profile";
    }

    @GetMapping("/updateProfile")
    public String getUpdateSite(@ModelAttribute("errorMessage") ErrorMessage errorMessage, Model model) {
        model.addAttribute("profile", profileService.getProfile());
        model.addAttribute("profileDto", new ProfileDto());
        model.addAttribute("errorMessage", errorMessage);
        return "profileUpdate";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute ProfileDto profileDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            profileService.updateProfile(profileDto);
            return "redirect:/profile";
        } else {
            List<ObjectError> errors = bindingResult.getAllErrors();
            StringBuilder errorMsg = new StringBuilder();
            errors.forEach(error1 -> errorMsg.append(error1.getDefaultMessage()).append('\n'));
            ErrorMessage errorMessage = new ErrorMessage(errorMsg.toString());
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return "redirect:/updateProfile";
        }
    }
}
