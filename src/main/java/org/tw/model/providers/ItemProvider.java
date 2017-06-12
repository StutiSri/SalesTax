package org.tw.model.providers;

import org.tw.model.item.Item;

public interface ItemProvider {
    Item createItem(String inputItem, Item item);
}
