package pl.rynski.chomiczek_workout.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.account.repository.UserRepository;
import pl.rynski.chomiczek_workout.profile.model.*;
import pl.rynski.chomiczek_workout.profile.modelDto.ProfileUserDto;
import pl.rynski.chomiczek_workout.profile.repository.*;

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

    public Profile getProfile() {
        Profile profile = profileRepository.findById(getIdOfActiveUser()).get();
        return profile;
    }

    public ProfileUserDto getProfileDto() {
        Profile profile = profileRepository.findById(getIdOfActiveUser()).get();
        ProfileUserDto profileUserDto = new ProfileUserDto();
        if(!profile.getWeightList().isEmpty()) {
            profileUserDto.setWeight(profile.getWeightList().get(profile.getWeightList().size() - 1).getSize());
            profileUserDto.setChestSize(profile.getChestSizeList().get(profile.getChestSizeList().size() - 1).getSize());
            profileUserDto.setArmSize(profile.getArmSizeList().get(profile.getArmSizeList().size() - 1).getSize());
            profileUserDto.setForearmSize(profile.getForearmSizeList().get(profile.getForearmSizeList().size() - 1).getSize());
            profileUserDto.setThighSize(profile.getThighSizeList().get(profile.getThighSizeList().size() - 1).getSize());
            profileUserDto.setCalfSize(profile.getCalfSizeList().get(profile.getCalfSizeList().size() - 1).getSize());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            profileUserDto.setLastUpdate(LocalDateTime.now().format(formatter));
        }
        return profileUserDto;
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

    public void updateProfile(ProfileUserDto profileUserDto) {
        Profile profile = profileRepository.findById(getIdOfActiveUser()).get();

        if(profileUserDto.getWeight() != null)
            profile.getWeightList().add(new Weight(profile, profileUserDto.getWeight()));
        else
            profile.getWeightList().add(new Weight(profile, profile.getWeightList().get(profile.getWeightList().size() - 1).getSize()));

        if(profileUserDto.getChestSize() != null)
            profile.getChestSizeList().add(new ChestSize(profile, profileUserDto.getChestSize()));
        else
            profile.getChestSizeList().add(new ChestSize(profile, profile.getChestSizeList().get(profile.getChestSizeList().size() - 1).getSize()));

        if(profileUserDto.getArmSize() != null)
            profile.getArmSizeList().add(new ArmSize(profile, profileUserDto.getArmSize()));
        else {

            profile.getArmSizeList().add(new ArmSize(profile, profile.getArmSizeList().get(profile.getArmSizeList().size() - 1).getSize()));
        }

        if(profileUserDto.getCalfSize() != null)
            profile.getCalfSizeList().add(new CalfSize(profile, profileUserDto.getCalfSize()));
        else
            profile.getCalfSizeList().add(new CalfSize(profile, profile.getCalfSizeList().get(profile.getCalfSizeList().size() - 1).getSize()));

        if(profileUserDto.getThighSize() != null)
            profile.getThighSizeList().add(new ThighSize(profile, profileUserDto.getThighSize()));
        else
            profile.getThighSizeList().add(new ThighSize(profile, profile.getThighSizeList().get(profile.getThighSizeList().size() - 1).getSize()));

        if(profileUserDto.getForearmSize() != null)
            profile.getForearmSizeList().add(new ForearmSize(profile, profileUserDto.getForearmSize()));
        else
            profile.getForearmSizeList().add(new ForearmSize(profile, profile.getForearmSizeList().get(profile.getForearmSizeList().size() - 1).getSize()));

        profile.getDateList().add(new UpdateDate(profile, LocalDateTime.now()));
        profileRepository.save(profile);
    }

}
