package com.amigoscode.common.extensions;


import com.amigoscode.common.results.AppError;
import com.amigoscode.common.results.ErrorKind;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ProblemExtensions {

    private ProblemExtensions() {
    }

    public static ResponseEntity<ProblemDetail> toProblem(
            List<AppError> errors) {

        if (errors == null || errors.isEmpty()) {
            return problem(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "An unexpected error occurred."
            );
        }

        if (errors.stream().allMatch(
                error -> error.type() == ErrorKind.VALIDATION)) {
            return validationProblem(errors);
        }

        return problem(errors.getFirst());
    }

    private static ResponseEntity<ProblemDetail> problem(
            AppError error) {

        HttpStatus status = switch (error.type()) {
            case CONFLICT -> HttpStatus.CONFLICT;
            case VALIDATION -> HttpStatus.BAD_REQUEST;
            case NOT_FOUND -> HttpStatus.NOT_FOUND;
            case UNAUTHORIZED -> HttpStatus.UNAUTHORIZED;
            case FORBIDDEN -> HttpStatus.FORBIDDEN;
            case FAILURE, UNEXPECTED ->
                    HttpStatus.INTERNAL_SERVER_ERROR;
        };

        return problem(status, error.description());
    }

    private static ResponseEntity<ProblemDetail> problem(
            HttpStatus status,
            String description) {

        ProblemDetail details = ProblemDetail.forStatus(status);
        details.setTitle(description);

        return ResponseEntity.status(status).body(details);
    }

    private static ResponseEntity<ProblemDetail> validationProblem(
            List<AppError> errors) {

        Map<String, List<String>> errorsByCode = new LinkedHashMap<>();

        for (AppError error : errors) {
            errorsByCode
                    .computeIfAbsent(
                            error.code(),
                            ignored -> new java.util.ArrayList<>())
                    .add(error.description());
        }

        ProblemDetail details =
                ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        details.setTitle("One or more validation errors occurred.");
        details.setProperty("errors", errorsByCode);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(details);
    }
}
