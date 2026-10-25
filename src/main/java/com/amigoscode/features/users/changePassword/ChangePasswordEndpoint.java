package com.amigoscode.features.users.changePassword;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.UsersRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangePasswordEndpoint {
    private final ChangePasswordHandler handler;

    public ChangePasswordEndpoint(ChangePasswordHandler handler ){
        this.handler = handler;
    }

    @PutMapping(UsersRouteConsts.CHANGE_USER_PASSWORD)
    public ResponseEntity<?> handle(@PathVariable String id, @RequestBody ChangePasswordRequest request) {

        var result = handler.handle(id, request);
        return result.match(_-> ResponseEntity.noContent().build(), ProblemExtensions::toProblem);
    }
}
