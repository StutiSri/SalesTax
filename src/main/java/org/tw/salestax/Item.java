package org.tw.salestax;

import java.text.DecimalFormat;

import static org.tw.salestax.SalesTaxValues.SALES_TAX;

public class Item {
    private int quantity;
    private String name;
    private double shelfPrice;
    private double salesTax;

    public Item(int quantity, String name, double shelfPrice) {
        this.quantity = quantity;
        this.name = name;
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
        if(SalesTaxExemptionList.fromString(name) != null)
            return salesTax;
        salesTax = (shelfPrice * SALES_TAX.getValue())/100;
        return salesTax;
    }
}
