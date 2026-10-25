package com.amigoscode.features.users.getUserByUsername;

import com.amigoscode.common.extensions.ProblemExtensions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserByUsernameEndpoint {
    private final GetUserByUsernameHandler handler;

    public GetUserByUsernameEndpoint(GetUserByUsernameHandler handler) {
        this.handler = handler;
    }

    public ResponseEntity<?> getUserByUsername(@PathVariable String email){

        var result = handler.handle(email);

        return result.match(
                ResponseEntity::ok,
                ProblemExtensions::toProblem
        );
    }
}
