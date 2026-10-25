package com.amigoscode.features.users.reactivateAccount;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Success;
import com.amigoscode.features.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReActivateAccountHandler {
    private final UserRepository userRepository;

    public ReActivateAccountHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Result<Success> handle(String userId) {
        var user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return Result.failure(ApplicationErrors.USER_NOT_FOUND);
        }

        var existUser = user.get();

        existUser.setAccountLocked(true);

        userRepository.save(existUser);

        return Result.success(Results.SUCCESS);
    }
}

