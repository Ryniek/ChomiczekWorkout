package pl.rynski.chomiczek_workout.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.profile.model.*;
import pl.rynski.chomiczek_workout.profile.repository.*;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Weight getProfile() {
        Optional<Profile> profile = profileRepository.findById(1L);
        return profile.get().getWeightList().get(0);
    }

    @EventListener(ApplicationReadyEvent.class)
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
    }

}
