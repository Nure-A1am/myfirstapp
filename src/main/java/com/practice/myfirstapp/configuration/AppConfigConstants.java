package com.practice.myfirstapp.configuration;

public class AppConfigConstants {


    public static final String[] AUTHORIZED_PAGE_ACCESS = {"/","/employee/update/{id}","/employee/edit/{id}","/employee/new","/employee/delete/{id}","employee/list"};
    public static final String[] OTHER_EMPLOYEE_PAGE_ACCESS = {"/AccessDenied"};
    public static final String[] PUBLIC_PAGE_ACCESS = {"/", "/welcome"};

    public static final String[] GENERAL_EMPLOYEE_ROLES = {"customer_support","sales_executive","sales_manager"};
    public static final String[] AUTHORIZED_EMPLOYEE_ROLES = {"hr_manager","it_support"};
    public static final String EMPLOYEE_ID = "{id}";
    public static final String INDEX_URL = "/";
    public static final String ALL_API_URL_PATTERN = "/api/v1/employee/**";

    public static final String LOGIN_PAGE_URL = "/login";
    public static final String LOGIN_ERROR_PAGE_URL = "/login?error";
    public static final String LOGOUT_PAGE_URL = "/logout";
    public static final String LOGOUT_SUCCESS_PAGE_URL = "/login?logout";
    public static final String WELCOME_PAGE_URL = "/welcome";
    public static final String ACCESS_DENIED_PAGE_URL = "/AccessDenied";
    public static final String EMPLOYEE_LIST_URL = "/employee/list";
    public static final String ADD_EMPLOYEE_FORM_URL = "/employee/new";
    public static final String ADD_EMPLOYEE_PROCESS_URL = "/process/employee/add";
    public static final String UPDATE_EMPLOYEE_FORM_URL = "/employee/edit/" + EMPLOYEE_ID;
    public static final String DELETE_EMPLOYEE_PROCESS_URL = "/process/employee/delete/" + EMPLOYEE_ID;
    public static final String UPDATE_EMPLOYEE_PROCESS_URL = "/employee/update/" + EMPLOYEE_ID;


    public static final String[] ALL_API_URL = {"/api/v1/employees", "/api/v1/employee/register{id}", "/api/v1/employee/update/{id}", "{id}"};
    public static final String API_BASE_URL = "/api/v1/employee";
    public static final String API_ADD_EMPLOYEE_URL = "/register";
    public static final String API_UPDATE_EMPLOYEE_URL = "/update/";

//    public static final String SECRET = "YXBpX3VzZXI6eW91ci1hcGkta2V5";
//    public static final long EXPIRATION_TIME = 900_000; // 15 mins
//    public static final String TOKEN_PREFIX = "Bearer ";
//    public static final String HEADER_STRING = "Authorization";
//    public static final String SIGN_UP_URL = "/api/services/controller/user";
}
