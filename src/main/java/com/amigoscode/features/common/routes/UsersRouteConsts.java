package com.amigoscode.features.common.routes;

public class UsersRouteConsts {
    private UsersRouteConsts(){
        
    }
    public final static String USER_BASE_ROUTE = "api/users";
    public final static String GET_USER_BY_ID = USER_BASE_ROUTE + "/{id}";
    public final static String UPDATE_USER = USER_BASE_ROUTE + "/{id}";
    public final static String CHANGE_USER_PASSWORD = USER_BASE_ROUTE +"/{id}/change-password";
    public final static String DELETE_USER = USER_BASE_ROUTE + "/{id}";
    public final static String DEACTIVATE_USER = USER_BASE_ROUTE +"/{id}/deactivate";
    public final static String REACTIVATE_USER = USER_BASE_ROUTE +"/{id}/reactivate";

}
