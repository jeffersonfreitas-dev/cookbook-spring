package dev.jeffersonfreitas.restapicookbok.utils.validations.unique_name.customer;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCustomerNameValidator.class)
public @interface UniqueCustomerName {
    String message() default "Name must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
