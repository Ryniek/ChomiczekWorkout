package pl.rynski.chomiczek_workout.workout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.workout.model.Workout;
import pl.rynski.chomiczek_workout.workout.repository.WorkoutRepository;

@Service
public class WorkoutService {

    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public void createWorkout(Long id) {
        Workout workout = new Workout(id);
        workoutRepository.save(workout);
    }
}
