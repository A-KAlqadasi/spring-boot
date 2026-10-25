package com.amigoscode.features.users.deleteUser;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.UsersRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserEndpoint {

    private final DeleteUserHandler handler;

    public DeleteUserEndpoint(DeleteUserHandler handler) {
        this.handler = handler;
    }

    @DeleteMapping(UsersRouteConsts.DELETE_USER)
    public ResponseEntity<?> deleteUser(@PathVariable String id) {

        var result = handler.handle(id);

        return result.match(
                _-> ResponseEntity.noContent().build(),
                ProblemExtensions::toProblem
        );
    }
}
