package com.amigoscode.features.products.getproduct;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.ProductsRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GetProductByIdEndpoint {
    private final GetProductByIdHandler handler;
    GetProductByIdEndpoint(GetProductByIdHandler handler) {
        this.handler = handler;
    }

    @GetMapping(ProductsRouteConsts.GET_PRODUCT_BY_ID)
    public ResponseEntity<?> GetProduct(@PathVariable UUID id) {

        var result = handler.handle(id);

        return result.match(ResponseEntity::ok,
                ProblemExtensions::toProblem);
    }

}
