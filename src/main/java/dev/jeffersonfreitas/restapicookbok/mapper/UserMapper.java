package dev.jeffersonfreitas.restapicookbok.mapper;

import dev.jeffersonfreitas.restapicookbok.dto.user.UserRequest;
import dev.jeffersonfreitas.restapicookbok.dto.user.UserResponse;
import dev.jeffersonfreitas.restapicookbok.model.User;

public class UserMapper {

    public static User toEntity(UserRequest request) {
        return new User().create(request.getUsername(), request.getPassword());
    }

    public static UserResponse toResponse(User entity) {
        return UserResponse.builder()
                .uuid(entity.getUuid())
                .username(entity.getUsername())
                .build();
    }
}
