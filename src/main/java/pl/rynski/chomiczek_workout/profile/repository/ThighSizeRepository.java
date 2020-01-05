package pl.rynski.chomiczek_workout.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.chomiczek_workout.profile.model.ThighSize;

@Repository
public interface ThighSizeRepository extends JpaRepository<ThighSize, Long> {
}
