package com.amigoscode.features.products.getall;

import com.amigoscode.features.products.shared.response.ProductResponse;
import com.amigoscode.features.common.routes.ProductsRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetProductsEndpoint {
    private final GetProductsHandler getProductsHandler;
    GetProductsEndpoint(GetProductsHandler getProductsHandler) {
        this.getProductsHandler = getProductsHandler;
    }

    @GetMapping(ProductsRouteConsts.PRODUCT_BASE_ROUTE)
    public ResponseEntity<List<ProductResponse>> Handle() {
        var response  = getProductsHandler.handle();

        return ResponseEntity.ok(response);
    }
}
