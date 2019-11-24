package pl.rynski.chomiczek_workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rynski.chomiczek_workout.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
