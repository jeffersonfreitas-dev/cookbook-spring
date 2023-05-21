package dev.jeffersonfreitas.restapicookbok.controller;

import dev.jeffersonfreitas.restapicookbok.dto.user.UserRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @PostMapping
    public void create(@RequestBody @Valid UserRequest request) {
        System.out.println(request);
    }
}
