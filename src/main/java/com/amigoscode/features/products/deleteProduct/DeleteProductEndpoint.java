package com.amigoscode.features.products.deleteProduct;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.ProductsRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeleteProductEndpoint {
    private final DeleteProductHandler handler;
    DeleteProductEndpoint(DeleteProductHandler handler) {
        this.handler = handler;
    }

    @DeleteMapping(ProductsRouteConsts.DELETE_PRODUCT)
    public ResponseEntity<?> GetProduct(@PathVariable UUID id) {

        var result = handler.handle(id);

        return result.match(_->ResponseEntity.noContent().build(),
                ProblemExtensions::toProblem);
    }

}
