package org.tw.salestax;

import org.tw.model.item.Item;
import org.tw.model.item.TaxableItem;

import java.util.ArrayList;

public class BillCalculator {

    private double totalSalesTax, totalAmount;

    public BillCalculator(ArrayList<Item> itemList) {
        calculateBillComponents(itemList);
    }

    private void calculateBillComponents(ArrayList<Item> itemList) {
        totalSalesTax = 0;
        for (Item item : itemList) {
            totalSalesTax += item.getSalesTax();
            totalAmount += item.getPrice();
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
