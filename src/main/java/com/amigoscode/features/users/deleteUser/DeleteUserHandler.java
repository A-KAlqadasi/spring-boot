package com.amigoscode.features.users.deleteUser;

import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Deleted;
import com.amigoscode.features.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserHandler {
    private final UserRepository userRepository;

    public DeleteUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<Deleted> handle(String userId) {


        return Result.success(Results.DELETED);
    }

}
