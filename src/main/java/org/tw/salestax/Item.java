package org.tw.salestax;

import static org.tw.salestax.SalesTaxValues.IMPORT_SALES_TAX;
import static org.tw.salestax.SalesTaxValues.SALES_TAX;

public class Item {
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
    }

    @Override
    public String toString() {
        return quantity + " " + name.trim() + " - " + shelfPrice;
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }

    public double calculateSalesTax() {
        salesTax = 0;
        if(SalesTaxExemptionList.fromString(name) == null)
            salesTax = (shelfPrice * SALES_TAX.getValue())/100;
        if(isImported)
            salesTax += (shelfPrice * IMPORT_SALES_TAX.getValue())/100;
        return salesTax;
    }
}
