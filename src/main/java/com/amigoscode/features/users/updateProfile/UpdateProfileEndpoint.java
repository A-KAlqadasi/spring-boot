package com.amigoscode.features.users.updateProfile;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.UsersRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateProfileEndpoint {
    private final UpdateProfileHandler handler;

    public UpdateProfileEndpoint(UpdateProfileHandler handler ){
        this.handler = handler;
    }

    @PutMapping(UsersRouteConsts.UPDATE_USER)
    public ResponseEntity<?> handle(@PathVariable String id, @RequestBody UpdateProfileRequest request) {

        var result = handler.handle(id, request);
        return result.match(_-> ResponseEntity.noContent().build(), ProblemExtensions::toProblem);
    }
}
