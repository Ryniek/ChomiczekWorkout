package pl.rynski.chomiczek_workout.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rynski.chomiczek_workout.profile.modelDto.ProfileDto;
import pl.rynski.chomiczek_workout.profile.service.ProfileService;

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
    public String getUpdateSite(Model model) {
        model.addAttribute("profile", new ProfileDto());
        return "profileUpdate";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute ProfileDto profileDto) {
        profileService.updateProfile(profileDto);
        return "redirect:/profile";
    }
}
