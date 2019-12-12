package pl.rynski.chomiczek_workout.service;

import pl.rynski.chomiczek_workout.model.Parameter;

import java.time.LocalDate;

public interface UserService {
        Parameter getParameters(Long userId, LocalDate date, String typeOfParameter);
        void deleteParameter(Long userId, LocalDate date, String typeOfParameter);
        void addParameter(Parameter newParameter, Long userId, LocalDate date, String typeOfParameter);
        void editParameter(Parameter newParameter, Long userId, LocalDate date, String typeOfParameter);
}
