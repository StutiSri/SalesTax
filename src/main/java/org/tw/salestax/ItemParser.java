package org.tw.salestax;

import org.tw.model.item.TaxableItem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public TaxableItem createItem(String inputItem) {
        final String PRICE_INDICATOR = " at ";

        if(!isValidInput(inputItem))
            return null;

        String[] itemDetails = inputItem.split(PRICE_INDICATOR);
        double shelfPrice = Double.parseDouble(itemDetails[1]);
        int quantity = getQuantityFromItemDetails(itemDetails[0]);
        String name = getNameFromItemDetails(itemDetails[0]);

        return new TaxableItem(quantity, name, shelfPrice);
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
