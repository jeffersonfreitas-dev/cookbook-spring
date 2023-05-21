package dev.jeffersonfreitas.restapicookbok.dto.user;

import dev.jeffersonfreitas.restapicookbok.validations.StrongPassword;
import dev.jeffersonfreitas.restapicookbok.validations.UniqueName;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserRequest {

    @NotBlank(message = "{user.name.required}")
    @UniqueName(message = "{user.name.invalid}")
    private String name;

    @NotBlank(message = "{user.password.required}")
    @StrongPassword(message = "Password must be strong")
    private String password;

    public UserRequest() {}

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
