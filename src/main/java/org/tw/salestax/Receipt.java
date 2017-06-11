package org.tw.salestax;

import java.util.ArrayList;

public class Receipt {
    private final ArrayList<Item> items;
    private final double salesTaxInfo;
    private final double totalAmountInfo;

    public Receipt(ArrayList<Item> items, double salesTaxInfo, double totalAmountInfo) {
        this.items = items;
        this.salesTaxInfo = salesTaxInfo;
        this.totalAmountInfo = totalAmountInfo;
    }

    @Override
    public String toString() {
        String receipt = "";
        for(Item item : items)
            receipt += item + "\n";
        receipt += "Sales Taxes - " + String.format("%.2f",salesTaxInfo) + "\n";
        receipt += "Total - " + String.format("%.2f",totalAmountInfo) + "\n\n";
        return receipt;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getSalesTax() {
        return String.format("%.2f", salesTaxInfo);
    }

    public String getTotalAmount() {
        return String.format("%.2f", totalAmountInfo);
    }
}
