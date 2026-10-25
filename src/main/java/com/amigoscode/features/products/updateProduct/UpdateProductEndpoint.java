package com.amigoscode.features.products.updateProduct;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.ProductsRouteConsts;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UpdateProductEndpoint {
    private  final UpdateProductHandler handler;
    UpdateProductEndpoint(UpdateProductHandler handler){
        this.handler = handler;
    }

    @PutMapping(ProductsRouteConsts.UPDATE_PRODUCT)
    public ResponseEntity<?> addProduct(@PathVariable UUID id, @Valid @RequestBody UpdateProductRequest request) {

        var result = handler.handle(id, request);

        return  result.match(
                 _ -> ResponseEntity.noContent().build(),
                ProblemExtensions::toProblem
        );
    }
}

