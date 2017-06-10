package org.tw.salestax;

import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayList;

public class ShoppingBasket {

    public static final String PRICE_INDICATOR = "at";
    public static final String ITEM_IMPORTED_INDICATOR = "imported";

    public ArrayList<Item> createItemsFromList(ArrayList<String> inputItemList) {
        ArrayList<Item> itemList = new ArrayList<>();
        for(String inputItem : inputItemList){
            String[] itemDetails = inputItem.split(PRICE_INDICATOR);
            double shelfPrice = Double.parseDouble(itemDetails[1]);
            int quantity = getQuantityFromItemDetails(itemDetails[0]);
            String name = getNameFromItemDetails(itemDetails[0]);

            boolean isImported = false;
            if(itemDetails[0].contains(ITEM_IMPORTED_INDICATOR))
                isImported = true;

            itemList.add(new Item(quantity, name, isImported, shelfPrice));
        }
        return itemList;
    }

    private String getNameFromItemDetails(String itemDetail) {
        return itemDetail.split(" ",2)[1];
    }

    private int getQuantityFromItemDetails(String itemDetail) {
        String quantity = itemDetail.split(" ")[0];
        return Integer.parseInt(quantity);
    }
}
