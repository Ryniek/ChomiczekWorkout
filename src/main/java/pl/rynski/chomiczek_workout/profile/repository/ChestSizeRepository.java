package pl.rynski.chomiczek_workout.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.chomiczek_workout.profile.model.ChestSize;

@Repository
public interface ChestSizeRepository extends JpaRepository<ChestSize, Long> {
}
