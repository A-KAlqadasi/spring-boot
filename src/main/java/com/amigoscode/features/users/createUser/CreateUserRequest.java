package com.amigoscode.features.users.createUser;

public record CreateUserRequest(
        String id,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone
) {
}
