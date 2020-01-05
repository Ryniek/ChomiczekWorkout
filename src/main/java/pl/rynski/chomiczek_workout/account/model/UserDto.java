package pl.rynski.chomiczek_workout.account.model;

import pl.rynski.chomiczek_workout.account.validation.PasswordMatches;
import pl.rynski.chomiczek_workout.account.validation.ValidPassword;

@PasswordMatches
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
