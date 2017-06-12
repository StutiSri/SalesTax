package org.tw.salestax;

import org.tw.constants.SalesTaxExemptionList;

import static org.tw.constants.SalesTaxValues.IMPORT_SALES_TAX;
import static org.tw.constants.SalesTaxValues.SALES_TAX;

public class Item {
    private double finalPrice;
    private int quantity;
    private String name;
    private final boolean isImported;
    private double shelfPrice;
    private double salesTax;

    public Item(int quantity, String name, boolean isImported, double shelfPrice) {
        this.quantity = quantity;
        this.name = name;
        this.isImported = isImported;
        this.shelfPrice = shelfPrice;
        calculateSalesTax();
        finalPrice = shelfPrice + salesTax;
    }

    @Override
    public String toString() {
        return quantity + " " + name.trim() + " - " + String.format("%.2f", finalPrice);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item && toString().equals(obj.toString());
    }

    public void calculateSalesTax() {
        salesTax = 0;
        if (SalesTaxExemptionList.fromString(name) == null)
            salesTax = (shelfPrice * SALES_TAX.getValue()) / 100;

        if (isImported)
            salesTax += (shelfPrice * IMPORT_SALES_TAX.getValue()) / 100;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getShelfPrice() {
        return shelfPrice;
    }
}
