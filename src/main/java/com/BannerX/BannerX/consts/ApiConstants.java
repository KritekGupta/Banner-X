package com.BannerX.BannerX.consts;

public class ApiConstants {
    public static final String apiV1 = "api/v1/";
    public static final String storeLender = apiV1 + "deployLender";
    public static final String storeForm = apiV1 + "saveLender";
//    why the below is not working with apiV1 + "/lender/{lenderId}"
    public static final String getLenderById = "api/v1/lender/{lenderId}";
    public static final String getAllLenders = apiV1 + "deployedLender/getAll";
    public static final String getAll = apiV1 + "lender/getAll";
    public static final String edit = apiV1 + "lender/{lenderId}/edit";
    public static final String deleteFormOrLender = apiV1 + "lender/{lenderId}/delete";
    public static final String lendersByCategory = apiV1 + "/lenderData/{category}";
    public static final String getAllCategory = apiV1 + "lender/getAllCategory";
    public static final String getLenderScreen = apiV1 + "lender/{lenderId}/screen/{screenIndex}";
    public static final String saveToDeploy = apiV1 + "lender/{lenderId}/deploy";
}