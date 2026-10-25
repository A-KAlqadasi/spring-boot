package com.amigoscode.features.users.reactivateAccount;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.UsersRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReActivateAccountEndpoint {
    private final ReActivateAccountHandler handler;

    public ReActivateAccountEndpoint(ReActivateAccountHandler handler) {
        this.handler = handler;
    }

    @PutMapping(UsersRouteConsts.REACTIVATE_USER)
    public ResponseEntity<?> deActivateAccount(@PathVariable String id) {

        var result = handler.handle(id);

        return result.match(_-> ResponseEntity.noContent().build(), ProblemExtensions::toProblem);
    }
}
