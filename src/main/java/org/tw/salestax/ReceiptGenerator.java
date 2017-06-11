package org.tw.salestax;

import java.util.ArrayList;

public class ReceiptGenerator {
    public Receipt generateReceipt(ArrayList<String> inputItemList){
        ArrayList<Item> items = new ShoppingBasket().createItemsFromList(inputItemList);
        ArrayList<String> itemDetails = new ArrayList<>();
        for(Item item : items)
            itemDetails.add(item.toString());
        BillCalculator billCalculator = new BillCalculator();
        return new Receipt(items, billCalculator.calculateTotalSalesTax(items), billCalculator
                .calculateTotalAmount(items));
    }
}
