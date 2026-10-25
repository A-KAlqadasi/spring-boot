package com.amigoscode.features.products.shared.response;

import com.amigoscode.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id, String name, BigDecimal price, String sku, String categoryName) {

    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getSku(),
                product.getCategory().getName());
    }
    
}

