package pl.rynski.chomiczek_workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rynski.chomiczek_workout.model.User;

public interface AccountRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}