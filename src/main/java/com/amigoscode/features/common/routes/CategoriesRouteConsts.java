package com.amigoscode.features.common.routes;

public final class CategoriesRouteConsts {
    private CategoriesRouteConsts () {

    }
    public final static String BASE_ROUTE = "api/categories";
    public final static String GET_CATEGORY_BY_ID = BASE_ROUTE + "/{id}";
    public final static String UPDATE_CATEGORY = BASE_ROUTE + "/{id}";
    public final static String DELETE_CATEGORY = BASE_ROUTE + "/{id}";

}
