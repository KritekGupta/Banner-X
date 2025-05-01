package com.BannerX.BannerX.entity;

import lombok.Data;

public enum LenderCategory {
    GOLD_LOAN("Gold Loan"),
    VEHICLE_LOAN("Vehicle Loan"),
    HOME_LOAN("Home Loan"),
    PERSONAL_LOAN("Personal Loan"),
    EDUCATION_LOAN("Education Loan");

    private final String displayName;

    LenderCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
