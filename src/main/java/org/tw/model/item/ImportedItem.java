package org.tw.model.item;

import static org.tw.constants.SalesTaxValues.IMPORT_SALES_TAX;

public class ImportedItem implements Item {
    private final Item item;
    private final double salesTax;
    private double finalPrice;

    public ImportedItem(Item item) {
        this.item = item;
        salesTax = item.getSalesTax() +
                (getPrice() * IMPORT_SALES_TAX.getValue())/100;
        finalPrice += item.getFinalPrice() + salesTax;
    }

    @Override
    public double getSalesTax() {
        return salesTax;
    }

    @Override
    public double getPrice() {
        return item.getPrice();
    }

    @Override
    public String getQuantity() {
        return item.getQuantity();
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public String toString() {
        return item.getQuantity() + " " + item.getName().trim() + " - "
                + String.format("%.2f", finalPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ImportedItem))
            return false;
        return obj.toString().equals(toString());
    }

    public Item getItem() {
        return item;
    }
}
