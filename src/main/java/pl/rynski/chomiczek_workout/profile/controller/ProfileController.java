package pl.rynski.chomiczek_workout.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rynski.chomiczek_workout.profile.model.Profile;
import pl.rynski.chomiczek_workout.profile.model.Weight;
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
        Weight weight = profileService.getProfile();
        model.addAttribute("weight", weight);
        return "profile";
    }
}
