package pl.rynski.chomiczek_workout.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rynski.chomiczek_workout.account.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
