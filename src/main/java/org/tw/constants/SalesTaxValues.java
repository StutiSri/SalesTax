package org.tw.constants;

public enum SalesTaxValues {
    SALES_TAX(10), IMPORT_SALES_TAX(5);

    private final int value;

    SalesTaxValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
