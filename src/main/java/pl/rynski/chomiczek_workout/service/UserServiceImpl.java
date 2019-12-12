package pl.rynski.chomiczek_workout.service;


import pl.rynski.chomiczek_workout.model.Parameter;
import pl.rynski.chomiczek_workout.repository.UserRepository;

import java.time.LocalDate;


public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository profileRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Parameter getParameters(Long userId, LocalDate date, String typeOfParameter) {
        return null;
    }

    @Override
    public void deleteParameter(Long userId, LocalDate date, String typeOfParameter) {

    }

    @Override
    public void addParameter(Parameter newParameter, Long userId, LocalDate date, String typeOfParameter) {

    }

    @Override
    public void editParameter(Parameter newParameter, Long userId, LocalDate date, String typeOfParameter) {

    }
}
