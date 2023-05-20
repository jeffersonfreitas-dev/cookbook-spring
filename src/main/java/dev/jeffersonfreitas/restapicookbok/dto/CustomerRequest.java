package dev.jeffersonfreitas.restapicookbok.dto;

import dev.jeffersonfreitas.restapicookbok.validations.BirthDateBeforeNow;
import dev.jeffersonfreitas.restapicookbok.validations.UniqueName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
;import java.time.LocalDate;

public class CustomerRequest {

    @NotBlank(message = "{customer.name.required}")
    @UniqueName(message = "{customer.name.invalid}")
    private String name;

    @Pattern(regexp = "^[A-Z]{4}[0-9]{2}", message = "{customer.code.required}")
    private String code;

    @NotNull(message = "{customer.birthday.required}")
    @BirthDateBeforeNow(message = "{customer.birthday.invalid}")
    private LocalDate birthDate;

    public CustomerRequest(){}

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setCode(String code) {
        this.code = code.trim();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
