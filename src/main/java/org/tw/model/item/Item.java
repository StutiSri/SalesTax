package org.tw.model.item;

public interface Item {
    double getSalesTax();
    double getPrice();

    String getQuantity();

    String getName();

    double getFinalPrice();
}
