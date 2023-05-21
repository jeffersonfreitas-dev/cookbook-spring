package dev.jeffersonfreitas.restapicookbok.utils.validations.unique_name.user;

import dev.jeffersonfreitas.restapicookbok.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if(name == null) {
            return true;
        }
        return !repository.findByUsernameIgnoreCase(name).isPresent();
    }
}
