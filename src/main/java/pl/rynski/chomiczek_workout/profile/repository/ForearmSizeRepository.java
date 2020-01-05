package pl.rynski.chomiczek_workout.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.chomiczek_workout.profile.model.ForearmSize;

@Repository
public interface ForearmSizeRepository extends JpaRepository<ForearmSize, Long> {
}
