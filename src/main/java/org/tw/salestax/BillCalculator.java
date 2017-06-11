package org.tw.salestax;

import java.util.ArrayList;

public class BillCalculator {

    public double calculateTotalSalesTax(ArrayList<Item> itemList) {
        double totalSalesTax = 0;
        for(Item item : itemList)
            totalSalesTax += item.getSalesTax();
        totalSalesTax = roundOff(totalSalesTax);
        return totalSalesTax;
    }

    public double calculateTotalAmount(ArrayList<Item> itemList) {
        double totalPrice = calculateTotalSalesTax(itemList);
        for(Item item : itemList)
            totalPrice += item.getShelfPrice();
        return totalPrice;
    }

    private double roundOff(double value) {
        return Math.ceil(value * 20) / 20.0;
    }
}
