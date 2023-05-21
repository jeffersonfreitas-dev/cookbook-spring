package dev.jeffersonfreitas.restapicookbok.utils.validations.birthdate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BirthDateBeforeNowValidator.class)
public @interface BirthDateBeforeNow {
    String message() default "Birth date not should be before now";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
