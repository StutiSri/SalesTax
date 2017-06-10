package org.tw.salestax;

import java.util.ArrayList;

public class SalesTaxCalculator {

    public double calculateTotalSalesTax(ArrayList<Item> itemList) {
        double totalSalesTax = 0;
        for(Item item : itemList)
            totalSalesTax += item.getSalesTax();
        totalSalesTax = Math.round(totalSalesTax * 20.0) / 20.0;
        return totalSalesTax;
    }
}
