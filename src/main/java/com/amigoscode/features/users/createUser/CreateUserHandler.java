package com.amigoscode.features.users.createUser;

import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Success;
import com.amigoscode.features.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateUserHandler {
    private final UserRepository repository;

    public CreateUserHandler(UserRepository repository) {
        this.repository = repository;
    }

    public Result<Success> handle(CreateUserRequest request) {


        return Result.success(Results.SUCCESS);
    }

}
