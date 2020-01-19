package pl.rynski.chomiczek_workout.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.chomiczek_workout.workout.model.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
