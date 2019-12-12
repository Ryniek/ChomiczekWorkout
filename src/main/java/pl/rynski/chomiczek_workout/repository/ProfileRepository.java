package pl.rynski.chomiczek_workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rynski.chomiczek_workout.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
