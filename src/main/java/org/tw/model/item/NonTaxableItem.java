package org.tw.model.item;

import org.tw.constants.SalesTaxValues;

public class NonTaxableItem implements Item {
    private final Item item;

    public NonTaxableItem(Item item) {
        this.item = item;
    }

    @Override
    public double getSalesTax() {
        return 0;
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
        return item.getPrice();
    }

    @Override
    public String toString() {
        return item.getQuantity() + " " + item.getName().trim() + " - "
                + String.format("%.2f", getFinalPrice());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NonTaxableItem && obj.toString().equals(toString());
    }
}
