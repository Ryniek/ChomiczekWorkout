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
import pl.rynski.chomiczek_workout.profile.model.*;
import pl.rynski.chomiczek_workout.profile.modelDto.ErrorMessage;
import pl.rynski.chomiczek_workout.profile.modelDto.ProfileDto;
import pl.rynski.chomiczek_workout.profile.service.ProfileService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/weightData")
    @ResponseBody
    public String getWeightForChart() {
        List<UpdateDate> timeList = profileService.getProfile().getDateList();
        List<Weight> weightList = profileService.getProfile().getWeightList();
        JsonArray jsonDate = new JsonArray();
        JsonArray jsonWeight = new JsonArray();
        JsonObject json = new JsonObject();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm");
        timeList.forEach(time -> jsonDate.add(time.getUpdateDate().format(formatter)));
        weightList.forEach(weight -> jsonWeight.add(weight.getSize()));
        json.add("date", jsonDate);
        json.add("weight", jsonWeight);
        return json.toString();
    }

    @GetMapping("/bodyData")
    @ResponseBody
    public String getBodyForChart() {
        List<UpdateDate> timeList = profileService.getProfile().getDateList();
        List<ArmSize> armSizeList = profileService.getProfile().getArmSizeList();
        List<CalfSize> calfSizeList = profileService.getProfile().getCalfSizeList();
        List<ChestSize> chestSizeList = profileService.getProfile().getChestSizeList();
        List<ForearmSize> forearmSizeList = profileService.getProfile().getForearmSizeList();
        List<ThighSize> thighSizeList = profileService.getProfile().getThighSizeList();
        JsonArray jsonDate = new JsonArray();
        JsonArray jsonArmSize = new JsonArray();
        JsonArray jsonCalfSize = new JsonArray();
        JsonArray jsonChestSize = new JsonArray();
        JsonArray jsonForearmSize = new JsonArray();
        JsonArray jsonThighSize = new JsonArray();
        JsonObject json = new JsonObject();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm");
        timeList.forEach(time -> jsonDate.add(time.getUpdateDate().format(formatter)));
        armSizeList.forEach(armSize -> jsonArmSize.add(armSize.getSize()));
        calfSizeList.forEach(calfSize -> jsonCalfSize.add(calfSize.getSize()));
        chestSizeList.forEach(chestSize -> jsonChestSize.add(chestSize.getSize()));
        forearmSizeList.forEach(forearmSize -> jsonForearmSize.add(forearmSize.getSize()));
        thighSizeList.forEach(thighSize -> jsonThighSize.add(thighSize.getSize()));
        json.add("date", jsonDate);
        json.add("armSize", jsonArmSize);
        json.add("calfSize", jsonCalfSize);
        json.add("chestSize", jsonChestSize);
        json.add("forearmSize", jsonForearmSize);
        json.add("thighSize", jsonThighSize);
        return json.toString();
    }
}
