package org.tw.salestax;

import org.tw.model.item.Item;
import org.tw.model.item.TaxableItem;

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
        StringBuilder receipt = new StringBuilder();
        for (Item item : items)
            receipt.append(item).append("\n");
        receipt.append("Sales Taxes - ").append(String.format("%.2f", salesTaxInfo)).append("\n");
        receipt.append("Total - ").append(String.format("%.2f", totalAmountInfo)).append("\n\n");
        return receipt.toString();
    }
}
