package pl.rynski.chomiczek_workout.service;

import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.repository.ProfileRepository;


public class UserServiceImpl implements UserService{

    private ProfileRepository profileRepository;

    public UserServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public String getParameters(Long id) {
        return profileRepository.findById(id).toString();
    }

    @Override
    public void deleteParameter(String typeOfParameter) {

    }

    @Override
    public void addParameter(Double newParameter, String typeOfParameter) {

    }

    @Override
    public void editParameter(Double newParameter, String typeOfParameter) {

    }
}
