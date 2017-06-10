package org.tw.salestax;

public class Item {
    private int quantity;
    private String name;
    private boolean isImported;
    private double shelfPrice;
    private double finalPrice;

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
}
