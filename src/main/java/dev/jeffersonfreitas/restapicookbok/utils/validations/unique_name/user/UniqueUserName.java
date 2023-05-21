package dev.jeffersonfreitas.restapicookbok.utils.validations.unique_name.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserNameValidator.class)
public @interface UniqueUserName {
    String message() default "Username must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
