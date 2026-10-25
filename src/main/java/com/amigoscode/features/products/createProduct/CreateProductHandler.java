package com.amigoscode.features.products.createProduct;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.domain.Category;
import com.amigoscode.domain.Product;
import com.amigoscode.features.categories.CategoryRepository;
import com.amigoscode.features.products.ProductRepository;
import com.amigoscode.features.products.shared.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateProductHandler {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    CreateProductHandler(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Result<ProductResponse> handle(CreateProductRequest request) {

        Optional<Category> category = categoryRepository.findById(request.categoryId());

        if (category.isEmpty()) {
            return Result.failure(ApplicationErrors.CATEGORY_NOT_FOUND);
        }

        var productResult = Product
                .create(request.id(),
                        request.name(),
                        request.price(),
                        request.sku(),
                        category.get());

        if (productResult.isError()){
            return Result.failure(productResult.topError());
        }



        var product = productResult.value();

        productRepository.save(product);

        return Result.success(ProductResponse.fromProduct(product));
    }
}
