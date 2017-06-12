package org.tw.salestax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public Item createItem(String inputItem) {
        final String PRICE_INDICATOR = " at ";
        final String ITEM_IMPORTED_INDICATOR = "imported";

        if(!isValidInput(inputItem))
            return null;

        String[] itemDetails = inputItem.split(PRICE_INDICATOR);
        double shelfPrice = Double.parseDouble(itemDetails[1]);
        int quantity = getQuantityFromItemDetails(itemDetails[0]);
        String name = getNameFromItemDetails(itemDetails[0]);

        boolean isImported = false;
        if (itemDetails[0].contains(ITEM_IMPORTED_INDICATOR))
            isImported = true;

        return new Item(quantity, name, isImported, shelfPrice);
    }

    private boolean isValidInput(String inputItem) {
        final String VALID_INPUT_REGEX = "\\d+[\\s\\w+\\s]+at\\s\\d+(\\.\\d{1,2})?";
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
