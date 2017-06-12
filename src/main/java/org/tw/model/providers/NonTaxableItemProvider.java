package org.tw.model.providers;

import org.tw.constants.SalesTaxExemptionList;
import org.tw.model.item.Item;
import org.tw.model.item.NonTaxableItem;

public class NonTaxableItemProvider implements ItemProvider{
    @Override
    public Item createItem(String inputItem, Item item) {
        if(SalesTaxExemptionList.fromString(inputItem)!=null)
            return new NonTaxableItem(item);
        return item;
    }
}
