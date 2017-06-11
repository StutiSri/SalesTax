package org.tw.pojo;

import java.util.ArrayList;

public class ReceiptData {
    private ArrayList<ItemData> itemData;
    private String salesTax;
    private String totalAmount;

    public ArrayList<ItemData> getItemData() {
        return itemData;
    }

    public void setItemData(ArrayList<ItemData> itemData) {
        this.itemData = itemData;
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
