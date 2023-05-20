package dev.jeffersonfreitas.restapicookbok.validations;

import dev.jeffersonfreitas.restapicookbok.repository.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if (name == null) {
            return true;
        }
        return Objects.isNull(repository.findByNameIgnoreCase(name));
    }
}
