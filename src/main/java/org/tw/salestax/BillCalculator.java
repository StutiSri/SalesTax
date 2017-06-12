package org.tw.salestax;

import java.util.ArrayList;

public class BillCalculator {

    double totalSalesTax, totalAmount;

    public BillCalculator(ArrayList<Item> itemList) {
        calculateBillComponents(itemList);
    }

    private void calculateBillComponents(ArrayList<Item> itemList) {
        for (Item item : itemList) {
            totalSalesTax += item.getSalesTax();
            totalAmount += item.getShelfPrice();
        }
        totalSalesTax = roundOff(totalSalesTax);
        totalAmount += totalSalesTax;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private double roundOff(double value) {
        return Math.ceil(value * 20) / 20.0;
    }
}
