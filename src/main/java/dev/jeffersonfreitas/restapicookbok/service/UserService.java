package dev.jeffersonfreitas.restapicookbok.service;

import dev.jeffersonfreitas.restapicookbok.dto.user.UserRequest;
import dev.jeffersonfreitas.restapicookbok.dto.user.UserResponse;

public interface UserService {
    UserResponse create(UserRequest request);
}
