package com.amigoscode.features.users.deactivateAccount;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.UsersRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeActivateAccountEndpoint {
    private final DeActivateAccountHandler handler;

    public DeActivateAccountEndpoint(DeActivateAccountHandler handler) {
        this.handler = handler;
    }

    @PutMapping(UsersRouteConsts.DEACTIVATE_USER)
    public ResponseEntity<?> deActivateAccount(@PathVariable String id) {

        var result = handler.handle(id);

        return result.match(_-> ResponseEntity.noContent().build(), ProblemExtensions::toProblem);
    }
}
