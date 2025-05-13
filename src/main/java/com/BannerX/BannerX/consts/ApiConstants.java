package com.BannerX.BannerX.consts;

public class ApiConstants {
    public static final String storeLender = "api/lender";
    public static final String storeForm = "api/form";
    public static final String getLenderById = storeLender + "/{lenderId}";
    public static final String getAllLenders = "lender/getAll";
    public static final String getAll = "getAll";
    public static final String edit = "lender/{lenderId}/edit";
    public static final String deleteFormOrLender = "lender/{lenderId}/delete";
    public static final String lendersByCategory = "lender/{category}";
    public static final String getAllCategory = "lender/getAllCategory";
}