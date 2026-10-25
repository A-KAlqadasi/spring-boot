package com.amigoscode.common.results;


import java.util.List;

public interface IResult {

    List<AppError> errors();

    boolean isSuccess();

    default boolean isError() {
        return !isSuccess();
    }
}
