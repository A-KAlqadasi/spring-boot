package com.amigoscode.features.categories.getCategory;

import com.amigoscode.common.extensions.ProblemExtensions;
import com.amigoscode.features.common.routes.CategoriesRouteConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GetCategoryByIdEndpoint {
    private final GetCategoryByIdHandler handler;
    GetCategoryByIdEndpoint(GetCategoryByIdHandler handler) {
        this.handler = handler;
    }

    @GetMapping(CategoriesRouteConsts.GET_CATEGORY_BY_ID)
    public ResponseEntity<?> getCategory(@PathVariable UUID id) {

        var result = handler.handle(id);

        return result.match(ResponseEntity::ok,
                ProblemExtensions::toProblem);
    }

}
