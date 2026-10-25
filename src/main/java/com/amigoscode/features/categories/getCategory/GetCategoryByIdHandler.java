package com.amigoscode.features.categories.getCategory;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.features.categories.CategoryRepository;
import com.amigoscode.features.categories.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetCategoryByIdHandler {
    private final CategoryRepository repository;
    GetCategoryByIdHandler(CategoryRepository repository) {
        this.repository = repository;
    }

    public Result<CategoryResponse> handle(UUID id) {
        return repository.findById(id)
                .map(CategoryResponse::fromCategory)
                .map(Result::success)
                .orElseGet(()->Result.failure(ApplicationErrors.CATEGORY_NOT_FOUND));
    }
}
