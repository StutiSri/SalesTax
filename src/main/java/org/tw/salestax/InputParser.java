package org.tw.salestax;

import java.util.ArrayList;

public class InputParser {

    public ArrayList<Item> createItemsFromList(ArrayList<String> inputItemList) {
        ArrayList<Item> itemList = new ArrayList<>();
        for (String inputItem : inputItemList) {
            Item item = new ItemParser().createItem(inputItem);
            if(item == null)
                return null;
            itemList.add(item);
        }
        return itemList;
    }
}
