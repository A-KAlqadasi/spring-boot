package com.amigoscode.common.results;


import java.util.Objects;

public final class AppError {

    private final String code;
    private final String description;
    private final ErrorKind type;

    private AppError(String code, String description, ErrorKind type) {
        this.code = Objects.requireNonNull(code);
        this.description = Objects.requireNonNull(description);
        this.type = Objects.requireNonNull(type);
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }

    public ErrorKind type() {
        return type;
    }

    public static AppError failure() {
        return failure("Failure", "General failure.");
    }

    public static AppError failure(String code, String description) {
        return new AppError(code, description, ErrorKind.FAILURE);
    }

    public static AppError unexpected() {
        return unexpected("Unexpected", "Unexpected error.");
    }

    public static AppError unexpected(String code, String description) {
        return new AppError(code, description, ErrorKind.UNEXPECTED);
    }

    public static AppError validation() {
        return validation("Validation", "Validation error.");
    }

    public static AppError validation(String code, String description) {
        return new AppError(code, description, ErrorKind.VALIDATION);
    }

    public static AppError conflict() {
        return conflict("Conflict", "Conflict error.");
    }

    public static AppError conflict(String code, String description) {
        return new AppError(code, description, ErrorKind.CONFLICT);
    }

    public static AppError notFound() {
        return notFound("NotFound", "Not found error.");
    }

    public static AppError notFound(String code, String description) {
        return new AppError(code, description, ErrorKind.NOT_FOUND);
    }

    public static AppError unauthorized() {
        return unauthorized("Unauthorized", "Unauthorized error.");
    }

    public static AppError unauthorized(String code, String description) {
        return new AppError(code, description, ErrorKind.UNAUTHORIZED);
    }

    public static AppError forbidden() {
        return forbidden("Forbidden", "Forbidden error.");
    }

    public static AppError forbidden(String code, String description) {
        return new AppError(code, description, ErrorKind.FORBIDDEN);
    }

    public static AppError create(
            ErrorKind type,
            String code,
            String description) {
        return new AppError(code, description, type);
    }
}

