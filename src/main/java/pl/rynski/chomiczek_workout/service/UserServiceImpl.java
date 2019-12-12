package pl.rynski.chomiczek_workout.service;

import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.repository.ProfileRepository;

import java.time.LocalDateTime;
import java.util.Map;


public class UserServiceImpl implements UserService{

    private ProfileRepository profileRepository;

    public UserServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public Map<LocalDateTime, Double> getParameters(Long id, String typeOfParameter) {
        return null;
    }

    @Override
    public void deleteParameter(LocalDateTime date, String typeOfParameter) {

    }

    @Override
    public void addParameter(Double newParameter, LocalDateTime date, String typeOfParameter) {

    }

    @Override
    public void editParameter(Double newParameter, LocalDateTime date, String typeOfParameter) {

    }
}
