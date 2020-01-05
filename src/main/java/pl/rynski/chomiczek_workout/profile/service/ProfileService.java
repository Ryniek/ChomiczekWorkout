package pl.rynski.chomiczek_workout.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.profile.model.*;
import pl.rynski.chomiczek_workout.profile.modelDto.ProfileDto;
import pl.rynski.chomiczek_workout.profile.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileDto getProfile() {
        Profile profile = profileRepository.findById(1L).get();
        ProfileDto profileDto = new ProfileDto();
        if(!profile.getWeightList().isEmpty()) {
            profileDto.setWeight(profile.getWeightList().get(profile.getWeightList().size() - 1).getSize());
            profileDto.setChestSize(profile.getChestSizeList().get(profile.getChestSizeList().size() - 1).getSize());
            profileDto.setArmSize(profile.getArmSizeList().get(profile.getArmSizeList().size() - 1).getSize());
            profileDto.setForearmSize(profile.getForearmSizeList().get(profile.getForearmSizeList().size() - 1).getSize());
            profileDto.setThighSize(profile.getThighSizeList().get(profile.getThighSizeList().size() - 1).getSize());
            profileDto.setCalfSize(profile.getCalfSizeList().get(profile.getCalfSizeList().size() - 1).getSize());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            profileDto.setLastUpdate(LocalDateTime.now().format(formatter));
        }
        return profileDto;
    }

    public void createProfile(Long id) {
        Profile profile = new Profile(id);
        profileRepository.save(profile);
    }

    public void updateProfile(ProfileDto profileDto) {
        Profile profile = profileRepository.findById(1L).get();
        profile.getWeightList().add(new Weight(profile, profileDto.getWeight()));
        profile.getChestSizeList().add(new ChestSize(profile, profileDto.getChestSize()));
        profile.getArmSizeList().add(new ArmSize(profile, profileDto.getArmSize()));
        profile.getCalfSizeList().add(new CalfSize(profile, profileDto.getCalfSize()));
        profile.getThighSizeList().add(new ThighSize(profile, profileDto.getThighSize()));
        profile.getForearmSizeList().add(new ForearmSize(profile, profileDto.getForearmSize()));
        profile.getDateList().add(new UpdateDate(profile, LocalDateTime.now()));
        profileRepository.save(profile);
    }

/*    @EventListener(ApplicationReadyEvent.class)
    public void addInitialProfile() {
        Profile profile = new Profile(1L);
        profile.getWeightList().add(new Weight(profile, 80L));
        profile.getChestSizeList().add(new ChestSize(profile, 100L));
        profile.getArmSizeList().add(new ArmSize(profile, 60L));
        profile.getCalfSizeList().add(new CalfSize(profile, 40L));
        profile.getThighSizeList().add(new ThighSize(profile, 60L));
        profile.getForearmSizeList().add(new ForearmSize(profile, 35L));
        profile.getDateList().add(new UpdateDate(profile, LocalDate.now()));
        profileRepository.save(profile);
    }*/

}
