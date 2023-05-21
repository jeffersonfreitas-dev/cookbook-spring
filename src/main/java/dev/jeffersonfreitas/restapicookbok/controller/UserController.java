package dev.jeffersonfreitas.restapicookbok.controller;

import dev.jeffersonfreitas.restapicookbok.dto.user.UserRequest;
import dev.jeffersonfreitas.restapicookbok.dto.user.UserResponse;
import dev.jeffersonfreitas.restapicookbok.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse create(@RequestBody @Valid UserRequest request) {
        return userService.create(request);
    }
}
