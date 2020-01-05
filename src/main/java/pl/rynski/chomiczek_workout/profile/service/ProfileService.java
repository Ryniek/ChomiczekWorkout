package pl.rynski.chomiczek_workout.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.profile.model.*;
import pl.rynski.chomiczek_workout.profile.repository.*;

import java.time.LocalDate;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;
    private WeightRepository weightRepository;
    private ChestSizeRepository chestSizeRepository;
    private ArmSizeRepository armSizeRepository;
    private ForearmSizeRepository forearmSizeRepository;
    private ThighSizeRepository thighSizeRepository;
    private CalfSizeRepository calfSizeRepository;
    private UpdateDateRepository updateDateRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, WeightRepository weightRepository,
                          ChestSizeRepository chestSizeRepository, ArmSizeRepository armSizeRepository,
                          ForearmSizeRepository forearmSizeRepository, ThighSizeRepository thighSizeRepository,
                          CalfSizeRepository calfSizeRepository, UpdateDateRepository updateDateRepository) {
        this.profileRepository = profileRepository;
        this.weightRepository = weightRepository;
        this.chestSizeRepository = chestSizeRepository;
        this.armSizeRepository = armSizeRepository;
        this.forearmSizeRepository = forearmSizeRepository;
        this.thighSizeRepository = thighSizeRepository;
        this.calfSizeRepository = calfSizeRepository;
        this.updateDateRepository = updateDateRepository;
    }

    private Profile addProfile() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setUserId(1L);
        Weight weight = new Weight(50L);
        weightRepository.save(weight);
        profile.getWeightList().add(weight);
/*        ChestSize chestSize = new ChestSize(150L);
        chestSizeRepository.save(chestSize);
        profile.getChestSizeList().add(chestSize);
        ArmSize armSize = new ArmSize(40L);
        armSizeRepository.save(armSize);
        profile.getArmSizeList().add(armSize);
        ForearmSize forearmSize = new ForearmSize(20L);
        forearmSizeRepository.save(forearmSize);
        profile.getForearmSizeList().add(forearmSize);
        ThighSize thighSize = new ThighSize(60L);
        thighSizeRepository.save(thighSize);
        profile.getThighSizeList().add(thighSize);
        CalfSize calfSize = new CalfSize(35L);
        calfSizeRepository.save(calfSize);
        profile.getCalfSizeList().add(calfSize);
        UpdateDate updateDate = new UpdateDate(LocalDate.now());
        updateDateRepository.save(updateDate);
        profile.getDateList().add(updateDate);*/
        return profile;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeMethod() {
        Profile profile = addProfile();
        System.out.println(profile);
    }
}
