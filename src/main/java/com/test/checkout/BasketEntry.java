package com.test.checkout;

final class BasketEntry {

    private final String productCode;
    private final int quantity;
    private final double soldPrice;


    BasketEntry(String productCode, int quantity, double soldPrice) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.soldPrice = soldPrice;
    }

    String getProductCode() {
        return productCode;
    }

    int getQuantity() {
        return quantity;
    }

    double getSoldPrice() {
        return soldPrice;
    }
}
