package org.tw.model.providers;

import org.tw.model.item.Item;
import org.tw.salestax.ItemParser;

public class TaxableItemProvider implements ItemProvider {
    @Override
    public Item createItem(String inputItem, Item item) {
        return new ItemParser().createItem(inputItem);
    }
}
