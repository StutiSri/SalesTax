package org.tw.salestax;

public enum SalesTaxValues {
    SALES_TAX(10);

    private final int value;

    SalesTaxValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
