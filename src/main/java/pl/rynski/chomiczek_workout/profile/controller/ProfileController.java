package pl.rynski.chomiczek_workout.profile.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rynski.chomiczek_workout.profile.model.UpdateDate;
import pl.rynski.chomiczek_workout.profile.model.Weight;
import pl.rynski.chomiczek_workout.profile.modelDto.ErrorMessage;
import pl.rynski.chomiczek_workout.profile.modelDto.ProfileDto;
import pl.rynski.chomiczek_workout.profile.service.ProfileService;

import javax.validation.Valid;
import java.time.LocalDateTime;
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
        model.addAttribute("profile", profileService.getProfileDto());
        return "profile";
    }

    @GetMapping("/updateProfile")
    public String getUpdateSite(@ModelAttribute("errorMessage") ErrorMessage errorMessage, Model model) {
        model.addAttribute("profile", profileService.getProfileDto());
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

    @GetMapping("/chartData")
    @ResponseBody
    public String getDataForChart() {
        List<UpdateDate> timeList = profileService.getProfile().getDateList();
        List<Weight> weightList = profileService.getProfile().getWeightList();
        JsonArray jsonDate = new JsonArray();
        JsonArray jsonWeight = new JsonArray();
        JsonObject json = new JsonObject();
        timeList.forEach(time -> jsonDate.add(time.getUpdateDate().toString()));
        weightList.forEach(weight -> jsonWeight.add(weight.getSize()));
        json.add("date", jsonDate);
        json.add("weight", jsonWeight);
        return json.toString();


    }
}
