package com.amigoscode.features.users.getUserByUsername;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.features.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetUserByUsernameHandler {
    private final UserRepository userRepository;

    public GetUserByUsernameHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<UserResponse> handle(String email) {

        var user = userRepository.findByEmailIgnoreCase(email).orElse(null);

        if (user == null) {
            log.error("User with user name {} not found", email);

            return Result.failure(ApplicationErrors.USER_NOT_FOUND);
        }


        return Result.success(UserResponse.fromUser(user));
    }
}
