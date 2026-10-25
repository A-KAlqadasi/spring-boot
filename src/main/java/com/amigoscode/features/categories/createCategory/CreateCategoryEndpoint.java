package com.amigoscode.features.categories.createCategory;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.CategoriesRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CreateCategoryEndpoint {
    private final CreateCategoryHandler handler;

    public CreateCategoryEndpoint(CreateCategoryHandler handler) {
        this.handler = handler;
    }

    @PostMapping(CategoriesRouteConsts.BASE_ROUTE)
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest request) {

        var result = handler.handle(request);

        return result.match(
                category -> {
                    URI location = ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path(CategoriesRouteConsts.GET_CATEGORY_BY_ID)
                            .buildAndExpand(category.id())
                            .toUri();

                    return ResponseEntity
                            .created(location)
                            .body(category);
                },
                ProblemExtensions::toProblem
        );
    }

}
