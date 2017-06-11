package org.tw.salestax;

import org.tw.outputwriter.OutputWriter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingBasket {

    public static final String PRICE_INDICATOR = " at ";
    public static final String ITEM_IMPORTED_INDICATOR = "imported";
    public static final String REGEX_FOR_VALID_INPUT = "\\d+[\\s\\w]+\\sat\\s\\d+(\\.\\d{1,2})?";

    public ArrayList<Item> createItemsFromList(ArrayList<String> inputItemList) {
        ArrayList<Item> itemList = new ArrayList<>();
        for(String inputItem : inputItemList){
            if(!isValidInput(inputItem))
                return null;
            String[] itemDetails = inputItem.split(PRICE_INDICATOR);
            double shelfPrice = Double.parseDouble(itemDetails[1]);
            int quantity = getQuantityFromItemDetails(itemDetails[0]);
            String name = getNameFromItemDetails(itemDetails[0]);

            boolean isImported = false;
            if(itemDetails[0].contains(ITEM_IMPORTED_INDICATOR))
                isImported = true;

            itemList.add(new Item(quantity, name,isImported, shelfPrice));
        }
        return itemList;
    }

    private boolean isValidInput(String inputItem) {
        Pattern inputPattern = Pattern.compile(REGEX_FOR_VALID_INPUT);
        Matcher matcher = inputPattern.matcher(inputItem);
        return matcher.matches();
    }

    private String getNameFromItemDetails(String itemDetail) {
        return itemDetail.split(" ",2)[1];
    }

    private int getQuantityFromItemDetails(String itemDetail) {
        String quantity = itemDetail.split(" ")[0];
        return Integer.parseInt(quantity);
    }
}
