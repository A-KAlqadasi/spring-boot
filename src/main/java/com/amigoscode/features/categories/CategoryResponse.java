package com.amigoscode.features.categories;

import com.amigoscode.domain.Category;

import java.util.UUID;

public record CategoryResponse(UUID id, String name) {
    public static CategoryResponse fromCategory(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}
