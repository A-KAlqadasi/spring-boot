package com.amigoscode.features.categories.createCategory;

import com.amigoscode.common.results.Result;
import com.amigoscode.domain.Category;
import com.amigoscode.features.categories.CategoryRepository;
import com.amigoscode.features.categories.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryHandler {
    private final CategoryRepository categoryRepository;

    public CreateCategoryHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Result<CategoryResponse> handle(CreateCategoryRequest request) {

        var categoryResult = Category.create(request.id(), request.name());

        if (categoryResult.isError()){
            return Result.failure(categoryResult.topError());
        }

        var category = categoryResult.value();

        categoryRepository.save(category);

        return Result.success(CategoryResponse.fromCategory(category));
    }
}
