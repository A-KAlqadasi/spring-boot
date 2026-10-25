package com.amigoscode.common.results;


import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public final class Result<T> implements IResultOf<T> {

    private final T value;
    private final List<AppError> appErrors;
    private final boolean success;

    private Result(T value, List<AppError> appErrors, boolean success) {
        this.success = success;

        if (success) {
            this.value = Objects.requireNonNull(
                    value,
                    "A successful Result must have a value."
            );
            this.appErrors = List.of();
        } else {
            if (appErrors == null || appErrors.isEmpty()) {
                throw new IllegalArgumentException(
                        "A failed Result must contain at least one error."
                );
            }

            this.value = null;
            this.appErrors = List.copyOf(appErrors);
        }
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, List.of(), true);
    }

    public static <T> Result<T> failure(AppError appError) {
        return new Result<>(
                null,
                List.of(Objects.requireNonNull(appError)),
                false
        );
    }

    public static <T> Result<T> failure(List<AppError> appErrors) {
        return new Result<>(null, appErrors, false);
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean isError() {
        return !success;
    }

    @Override
    public T value() {
        if (!success) {
            throw new IllegalStateException(
                    "Cannot access the value of a failed Result."
            );
        }

        return value;
    }

    @Override
    public List<AppError> errors() {
        return appErrors;
    }

    public AppError topError() {
        if (success) {
            throw new IllegalStateException(
                    "A successful Result has no error."
            );
        }

        return appErrors.getFirst();
    }

    public <R> R match(
            Function<? super T, ? extends R> onValue,
            Function<List<AppError>, ? extends R> onError) {

        Objects.requireNonNull(onValue);
        Objects.requireNonNull(onError);

        return success
                ? onValue.apply(value)
                : onError.apply(appErrors);
    }
}