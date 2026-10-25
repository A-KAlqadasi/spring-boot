package com.amigoscode.features.products.createProduct;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.ProductsRouteConsts;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController()
public class CreateProductEndpoint {
    private  final CreateProductHandler handler;
    CreateProductEndpoint(CreateProductHandler handler){
        this.handler = handler;
    }

    @PostMapping(ProductsRouteConsts.PRODUCT_BASE_ROUTE)
    public ResponseEntity<?> addProduct(@Valid @RequestBody CreateProductRequest request) {

        var result = handler.handle(request);

        return  result.match(
                product -> {
                    URI location = ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path(ProductsRouteConsts.GET_PRODUCT_BY_ID)
                            .buildAndExpand(product.id())
                            .toUri();

                    return ResponseEntity
                            .created(location)
                            .body(product);
                },
                ProblemExtensions::toProblem
        );
    }
}

