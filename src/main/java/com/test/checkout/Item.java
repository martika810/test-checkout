package com.test.checkout;

public class Item{

    private final String code;
    private final String description;
    private final Double price;

    public Item(String code, String description, Double price) {
        CheckUtils.checkNotNullOrEmpty(code);
        CheckUtils.checkNotNullOrEmpty(description);
        CheckUtils.checkNotNull(price);
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
