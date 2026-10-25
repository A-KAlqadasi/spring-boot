package com.amigoscode.features.products.getall;

import com.amigoscode.features.products.ProductRepository;
import com.amigoscode.features.products.shared.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsHandler {

    private final  ProductRepository productRepository;
    private GetProductsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> handle() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductResponse::fromProduct)
                .toList();
    }

}
