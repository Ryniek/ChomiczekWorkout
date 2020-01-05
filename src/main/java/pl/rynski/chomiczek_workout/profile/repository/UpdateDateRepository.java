package pl.rynski.chomiczek_workout.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.chomiczek_workout.profile.model.UpdateDate;

@Repository
public interface UpdateDateRepository extends JpaRepository<UpdateDate, Long> {
}
