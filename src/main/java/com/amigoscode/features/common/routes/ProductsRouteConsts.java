package com.amigoscode.features.common.routes;

public final class ProductsRouteConsts {
    private ProductsRouteConsts () {

    }
    public final static String PRODUCT_BASE_ROUTE = "api/products";
    public final static String GET_PRODUCT_BY_ID = PRODUCT_BASE_ROUTE + "/{id}";
    public final static String UPDATE_PRODUCT = PRODUCT_BASE_ROUTE + "/{id}";
    public final static String DELETE_PRODUCT = PRODUCT_BASE_ROUTE + "/{id}";

}


