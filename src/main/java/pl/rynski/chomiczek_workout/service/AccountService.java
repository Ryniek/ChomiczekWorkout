package pl.rynski.chomiczek_workout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.model.User;
import pl.rynski.chomiczek_workout.model.UserRole;
import pl.rynski.chomiczek_workout.repository.UserRepository;
import pl.rynski.chomiczek_workout.repository.UserRoleRepository;

@Service
public class AccountService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUserWithDefaultRole(User user) {
        UserRole userRole = userRoleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(userRole);
        String passHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passHash);
        userRepository.save(user);
    }
}
