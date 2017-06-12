package org.tw.model.item;

import static org.tw.constants.SalesTaxValues.SALES_TAX;

public class TaxableItem implements Item{
    private double finalPrice;
    private int quantity;
    private String name;
    private double shelfPrice;
    private double salesTax;

    public TaxableItem(int quantity, String name, double shelfPrice) {
        this.quantity = quantity;
        this.name = name;
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
        return obj instanceof TaxableItem && toString().equals(obj.toString());
    }

    public void calculateSalesTax() {
        salesTax = (shelfPrice * SALES_TAX.getValue()) / 100;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getPrice() {
        return shelfPrice;
    }

    @Override
    public String getQuantity() {
        return Integer.toString(quantity);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getFinalPrice() {
        return finalPrice;
    }

}
