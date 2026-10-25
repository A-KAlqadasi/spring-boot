package com.amigoscode.common.errors;

import com.amigoscode.common.results.AppError;

public class ApplicationErrors {
    private static final String ERROR_PREFIX = "MyErrors.";

    private ApplicationErrors() {}

    public static final AppError PRODUCT_ID_REQUIRED = AppError.validation(ERROR_PREFIX + "ProductIdRequired", "Product id is required");
    public static final AppError PRODUCT_NOT_FOUND = AppError.notFound(ERROR_PREFIX + "ProductNotFound",
            "Product is not found");

    public static final AppError PRODUCT_NAME_REQUIRED =
            AppError.validation(ERROR_PREFIX + "ProductNameRequired",
                            "Product name is required");

    public static final AppError PRODUCT_QUANTITY_MUST_BE_GREATER_THAN_ZERO =
            AppError.validation(ERROR_PREFIX + "ProductQuantityMustBeGreaterThanZero",
                    "Product quantity must be greater than zero");

    public static final AppError PRICE_SHOULD_NOT_BE_NEGATIVE =
            AppError.validation(ERROR_PREFIX + "PRICE_SHOULD_NOT_BE_NEGATIVE",
                    "Price should not be negative");

    public static final AppError CATEGORY_NOT_FOUND = AppError.notFound(ERROR_PREFIX + "CATEGORY_NOT_FOUND", "Category not found");

    public static final AppError USER_NOT_FOUND = AppError.notFound("USER_NOT_FOUND", "User not found");
}

