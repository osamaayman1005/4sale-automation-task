package com.foursale.automationtask.enums;

public enum ProductSortingOption {
    NAME_Z_TO_A("za"),
    NAME_A_TO_Z("az"),
    PRICE_LOW_TO_HIGH("lohi"),
    PRICE_HIGH_TO_LOW("hilo");

    private final String value;

    ProductSortingOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
