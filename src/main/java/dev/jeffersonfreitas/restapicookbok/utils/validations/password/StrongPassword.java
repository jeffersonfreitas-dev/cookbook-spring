package dev.jeffersonfreitas.restapicookbok.utils.validations.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StrongPasswordValidator.class)
public @interface StrongPassword {
    String message() default "Password must contain digits, lower, upper and special with min 8 and max 20 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
