package com.amigoscode.features.users.deactivateAccount;

import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Success;
import com.amigoscode.features.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeActivateAccountHandler {
    private final UserRepository userRepository;

    public DeActivateAccountHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Result<Success> handle(String userId) {

        return Result.success(Results.SUCCESS);
    }
}
