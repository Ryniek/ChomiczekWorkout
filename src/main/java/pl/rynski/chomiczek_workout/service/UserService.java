package pl.rynski.chomiczek_workout.service;

public interface UserService {
        String getParameters(Long id);
        void deleteParameter(String typeOfParameter);
        void addParameter(Double newParameter, String typeOfParameter);
        void editParameter(Double newParameter, String typeOfParameter);
}
