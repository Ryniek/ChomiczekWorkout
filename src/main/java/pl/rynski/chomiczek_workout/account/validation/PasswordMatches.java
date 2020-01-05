package pl.rynski.chomiczek_workout.account.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Hasła muszą być identyczne";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}