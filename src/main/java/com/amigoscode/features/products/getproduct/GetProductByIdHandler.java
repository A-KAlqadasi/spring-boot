package com.amigoscode.features.products.getproduct;

import com.amigoscode.common.errors.ApplicationErrors;
import com.amigoscode.common.results.Result;
import com.amigoscode.features.products.ProductRepository;
import com.amigoscode.features.products.shared.response.ProductResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetProductByIdHandler {
    private final ProductRepository repository;
    GetProductByIdHandler(ProductRepository repository) {
        this.repository = repository;
    }

    public Result<ProductResponse> handle(UUID id) {

        return repository.findById(id)
                .map(p-> ProductResponse.fromProduct(p))
                .map(Result::success)
                .orElseGet(()->Result.failure(ApplicationErrors.PRODUCT_NOT_FOUND));
    }
}
