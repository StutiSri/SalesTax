package org.tw.salestax;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingBasket {

    public static final String PRICE_INDICATOR = " at ";
    public static final String ITEM_IMPORTED_INDICATOR = "imported";
    public static final String VALID_INPUT_REGEX = "\\d+[\\s\\w+\\s]+at\\s\\d+(\\.\\d{1,2})?";

    public ArrayList<Item> createItemsFromList(ArrayList<String> inputItemList) {
        ArrayList<Item> itemList = new ArrayList<>();
        for (String inputItem : inputItemList) {
            if (!isValidInput(inputItem))
                return null;
            String[] itemDetails = inputItem.split(PRICE_INDICATOR);
            double shelfPrice = Double.parseDouble(itemDetails[1]);
            int quantity = getQuantityFromItemDetails(itemDetails[0]);
            String name = getNameFromItemDetails(itemDetails[0]);

            boolean isImported = false;
            if (itemDetails[0].contains(ITEM_IMPORTED_INDICATOR))
                isImported = true;

            itemList.add(new Item(quantity, name, isImported, shelfPrice));
        }
        return itemList;
    }

    private boolean isValidInput(String inputItem) {
        Pattern inputPattern = Pattern.compile(VALID_INPUT_REGEX);
        Matcher matcher = inputPattern.matcher(inputItem);
        return matcher.matches();
    }

    private String getNameFromItemDetails(String itemDetail) {
        return itemDetail.split(" ", 2)[1];
    }

    private int getQuantityFromItemDetails(String itemDetail) {
        String quantity = itemDetail.split(" ")[0];
        return Integer.parseInt(quantity);
    }
}
