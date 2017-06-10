package org.tw.salestax;

import java.util.ArrayList;

public class SalesTaxCalculator {

    public double calculateTotalSalesTax(ArrayList<Item> itemList) {
        double totalSalesTax = 0;
        for(Item item : itemList)
            totalSalesTax += item.getSalesTax();
        return roundOff(totalSalesTax);
    }

    public String calculateTotalAmount(ArrayList<Item> itemList) {
        double totalPrice = calculateTotalSalesTax(itemList);
        for(Item item : itemList)
            totalPrice += item.getShelfPrice();
        return String.format("%.2f", totalPrice);
    }

    private double roundOff(double value) {
        return Math.ceil(value * 20) / 20.0;
    }
}
