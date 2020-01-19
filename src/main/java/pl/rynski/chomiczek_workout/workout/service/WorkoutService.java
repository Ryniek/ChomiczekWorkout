package pl.rynski.chomiczek_workout.workout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.account.repository.UserRepository;
import pl.rynski.chomiczek_workout.workout.model.*;
import pl.rynski.chomiczek_workout.workout.repository.WorkoutRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    private UserRepository userRepository;
    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(UserRepository userRepository, WorkoutRepository workoutRepository) {
        this.userRepository = userRepository;
        this.workoutRepository = workoutRepository;
    }

    public void createWorkout(Long id) {
        Workout workout = new Workout(id);
        workoutRepository.save(workout);
    }

    public void addTraining(WorkoutDto workoutDto) {
        Workout workout = workoutRepository.findById(getIdOfActiveUser()).get();
        LocalDate date = LocalDate.now();
        if(workoutDto.getPullUpsQuantity() != 0) {
            workout.getPullUpList().add(new PullUp(workoutDto.getPullUpsQuantity(), workout, date));
        }
        if(workoutDto.getPumpsQuantity() != 0) {
            workout.getPumpList().add(new Pump(workoutDto.getPumpsQuantity(), workout, date));
        }
        if(workoutDto.getMuscleUpsQuantity() != 0) {
            workout.getMuscleUpList().add(new MuscleUp(workoutDto.getMuscleUpsQuantity(), workout, date));
        }
        if(workoutDto.getNote() != null) {
            workout.getNotes().add(new TrainingNote(workoutDto.getNote(), workout));
        }
        workoutRepository.save(workout);
    }

    public List<Pump> getQuantity() {
        return workoutRepository.findById(getIdOfActiveUser()).get().getPumpList();
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
}
