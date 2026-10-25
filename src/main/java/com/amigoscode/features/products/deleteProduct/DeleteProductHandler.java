package com.amigoscode.features.products.deleteProduct;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.common.results.Results;
import com.amigoscode.common.results.markers.Deleted;
import com.amigoscode.features.products.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductHandler {
    private final ProductRepository repository;
    DeleteProductHandler(ProductRepository repository) {
        this.repository = repository;
    }

    public Result<Deleted> handle(UUID id) {

        var product = repository.findById(id).orElse(null);

        if (product == null) {
            return Result.failure(ApplicationErrors.PRODUCT_NOT_FOUND);
        }

        repository.delete(product);

        return Result.success(Results.DELETED);
    }
}
