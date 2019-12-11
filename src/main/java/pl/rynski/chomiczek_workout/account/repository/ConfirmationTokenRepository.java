package pl.rynski.chomiczek_workout.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rynski.chomiczek_workout.account.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
}
