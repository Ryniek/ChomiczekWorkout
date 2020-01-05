package pl.rynski.chomiczek_workout.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.account.repository.UserRepository;
import pl.rynski.chomiczek_workout.profile.model.*;
import pl.rynski.chomiczek_workout.profile.modelDto.ProfileDto;
import pl.rynski.chomiczek_workout.profile.repository.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;
    private UserRepository userRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public ProfileDto getProfile() {
        Profile profile = profileRepository.findById(getIdOfActiveUser()).get();
        ProfileDto profileDto = new ProfileDto();
        if(!profile.getWeightList().isEmpty()) {
            profileDto.setWeight(profile.getWeightList().get(profile.getWeightList().size() - 1).getSize());
            profileDto.setChestSize(profile.getChestSizeList().get(profile.getChestSizeList().size() - 1).getSize());
            profileDto.setArmSize(profile.getArmSizeList().get(profile.getArmSizeList().size() - 1).getSize());
            profileDto.setForearmSize(profile.getForearmSizeList().get(profile.getForearmSizeList().size() - 1).getSize());
            profileDto.setThighSize(profile.getThighSizeList().get(profile.getThighSizeList().size() - 1).getSize());
            profileDto.setCalfSize(profile.getCalfSizeList().get(profile.getCalfSizeList().size() - 1).getSize());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            profileDto.setLastUpdate(LocalDateTime.now().format(formatter));
        }
        return profileDto;
    }

    private Long getIdOfActiveUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        Long id = userRepository.findByUsername(username).getId();
        return id;
    }

    public void createProfile(Long id) {
        Profile profile = new Profile(id);
        profileRepository.save(profile);
    }

    public void updateProfile(ProfileDto profileDto) {
        Profile profile = profileRepository.findById(getIdOfActiveUser()).get();
        profile.getWeightList().add(new Weight(profile, profileDto.getWeight()));
        profile.getChestSizeList().add(new ChestSize(profile, profileDto.getChestSize()));
        profile.getArmSizeList().add(new ArmSize(profile, profileDto.getArmSize()));
        profile.getCalfSizeList().add(new CalfSize(profile, profileDto.getCalfSize()));
        profile.getThighSizeList().add(new ThighSize(profile, profileDto.getThighSize()));
        profile.getForearmSizeList().add(new ForearmSize(profile, profileDto.getForearmSize()));
        profile.getDateList().add(new UpdateDate(profile, LocalDateTime.now()));
        profileRepository.save(profile);
    }

}
