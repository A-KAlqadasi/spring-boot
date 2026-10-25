package com.amigoscode.features.users.changePassword;

import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Success;
import com.amigoscode.features.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordHandler {
    private final UserRepository userRepository;

    public ChangePasswordHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<Success> handle(String userId, ChangePasswordRequest request){
        return Result.success(Results.SUCCESS);
    }
}
