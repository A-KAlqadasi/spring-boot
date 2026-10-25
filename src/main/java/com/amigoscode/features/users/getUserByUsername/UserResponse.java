package com.amigoscode.features.users.getUserByUsername;

import com.amigoscode.domain.users.User;

public record UserResponse(String id, String firstName, String lastName, String email) {

    public static UserResponse fromUser(User user) {
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
