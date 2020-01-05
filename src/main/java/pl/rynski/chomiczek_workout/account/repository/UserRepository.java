package pl.rynski.chomiczek_workout.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.rynski.chomiczek_workout.account.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE user.username = :userEmail OR user.email = :userEmail LIMIT 1", nativeQuery = true)
    User findByUsernameOrEmailMyImp(@Param("userEmail")String userEmail);
}
