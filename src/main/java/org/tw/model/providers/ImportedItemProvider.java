package org.tw.model.providers;

import org.tw.model.item.ImportedItem;
import org.tw.model.item.Item;

public class ImportedItemProvider implements ItemProvider {
    @Override
    public Item createItem(String inputItem, Item item) {
        String ITEM_IMPORTED_INDICATOR = " imported ";
        if (inputItem.contains(ITEM_IMPORTED_INDICATOR))
            return new ImportedItem(item);
        return item;
    }
}
