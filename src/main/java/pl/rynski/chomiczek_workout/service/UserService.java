package pl.rynski.chomiczek_workout.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserService {
        Map<LocalDateTime, Double> getParameters(Long id, String typeOfParameter);
        void deleteParameter(LocalDateTime date, String typeOfParameter);
        void addParameter(Double newParameter, LocalDateTime date, String typeOfParameter);
        void editParameter(Double newParameter, LocalDateTime date, String typeOfParameter);
}
