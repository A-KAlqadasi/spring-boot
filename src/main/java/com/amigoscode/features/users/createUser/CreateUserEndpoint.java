package com.amigoscode.features.users.createUser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserEndpoint {
    private final CreateUserHandler handler;

    public CreateUserEndpoint(CreateUserHandler handler) {
        this.handler = handler;
    }

    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) {

        return ResponseEntity.ok().build();
    }
}
