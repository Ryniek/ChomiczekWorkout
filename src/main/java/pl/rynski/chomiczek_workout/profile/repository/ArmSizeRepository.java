package pl.rynski.chomiczek_workout.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.chomiczek_workout.profile.model.ArmSize;

@Repository
public interface ArmSizeRepository extends JpaRepository<ArmSize, Long> {
}
