package com.amigoscode.features.products.updateProduct;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Updated;
import com.amigoscode.features.categories.CategoryRepository;
import com.amigoscode.features.products.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateProductHandler {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    UpdateProductHandler(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Result<Updated> handle(UUID id, UpdateProductRequest request) {

        var product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return Result.failure(ApplicationErrors.PRODUCT_NOT_FOUND);
        }
        
        var category = categoryRepository.findById(request.categoryId()).orElse(null);

        if (category == null) {
            return Result.failure(ApplicationErrors.CATEGORY_NOT_FOUND);
        }

        var productResult = product.update(request.name(), request.price(), request.sku(), category);

        if (productResult.isError()){
            return Result.failure(productResult.topError());
        }

        productRepository.save(product);

        return Result.success(Results.UPDATED);
    }
}
