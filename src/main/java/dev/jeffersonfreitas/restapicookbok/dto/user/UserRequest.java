package dev.jeffersonfreitas.restapicookbok.dto.user;

import dev.jeffersonfreitas.restapicookbok.utils.validations.password.StrongPassword;
import dev.jeffersonfreitas.restapicookbok.utils.validations.unique_name.user.UniqueUserName;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class UserRequest {

    @NotBlank(message = "{user.username.required}")
    @UniqueUserName(message = "{user.username.invalid}")
    private String username;

    @NotBlank(message = "{user.password.required}")
    @StrongPassword(message = "{user.password.invalid}")
    private String password;

    public UserRequest() {}

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
