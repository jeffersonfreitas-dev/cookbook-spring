package dev.jeffersonfreitas.restapicookbok.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class BirthDateBeforeNowValidator implements ConstraintValidator<BirthDateBeforeNow, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        if(date == null) {
            return true;
        }
        return date.isBefore(LocalDate.now());
    }
}
