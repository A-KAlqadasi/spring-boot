package com.amigoscode.features.products.shared.exceptions;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(UUID id) {
        super("Product with ID " + id + " was not found");
    }
}