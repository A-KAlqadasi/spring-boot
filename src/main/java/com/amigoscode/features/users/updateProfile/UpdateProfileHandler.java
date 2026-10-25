package com.amigoscode.features.users.updateProfile;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Updated;
import com.amigoscode.domain.users.User;
import com.amigoscode.features.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateProfileHandler {
    private final UserRepository userRepository;

    public UpdateProfileHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<Updated> handle(String userId, UpdateProfileRequest request) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            log.error("User with id {} not found", userId);
            return Result.failure(ApplicationErrors.USER_NOT_FOUND);
        }

        userRepository.save(user);

        return Result.success(Results.UPDATED);
    }
}
