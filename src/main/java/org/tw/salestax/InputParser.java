package org.tw.salestax;

import org.tw.model.item.Item;
import org.tw.model.providers.ImportedItemProvider;
import org.tw.model.providers.ItemProvider;
import org.tw.model.providers.NonTaxableItemProvider;
import org.tw.model.providers.TaxableItemProvider;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public ArrayList<Item> createItemsFromList(ArrayList<String> inputItemList) {
        ArrayList<Item> itemList = new ArrayList<>();
        Item item;

        List<ItemProvider> providerList = new ArrayList<>();
        providerList.add(new TaxableItemProvider());
        providerList.add(new NonTaxableItemProvider());
        providerList.add(new ImportedItemProvider());

        for (String inputItem : inputItemList) {
            item = null;

            for(ItemProvider provider : providerList)
                item = provider.createItem(inputItem, item);

            if(item == null)
                return null;

            itemList.add(item);
        }
        return itemList;
    }
}
