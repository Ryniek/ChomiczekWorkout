package pl.rynski.chomiczek_workout.model;

import pl.rynski.chomiczek_workout.validation.PasswordMatches;
import pl.rynski.chomiczek_workout.validation.ValidPassword;

@PasswordMatches(message = "Passwords are not equal")
public class UserDto {
    @ValidPassword
    private String password;
    private String confirmPassword;

    public UserDto() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
