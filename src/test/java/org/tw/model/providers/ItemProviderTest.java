package org.tw.model.providers;

import org.junit.Test;
import org.tw.model.item.ImportedItem;
import org.tw.model.item.Item;
import org.tw.model.item.NonTaxableItem;
import org.tw.model.item.TaxableItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemProviderTest {
    @Test
    public void TaxableItemProviderShouldCreateTaxableItemFromInputString(){
        Item expectedItem = new TaxableItem(1, "chocolate bar",
                5.0);

        Item item = new TaxableItemProvider().createItem
                (getTaxableItemInputString(), null);

        assertEquals(expectedItem, item);
    }

    private String getTaxableItemInputString() {
        return "1 chocolate bar at 5.00";
    }

    @Test
    public void ImportedItemProviderShouldCreateImportedItemFromInputString(){
        Item taxableItem = new TaxableItem(1, "imported music CD",
                10.0);
        Item expectedItem = new ImportedItem(taxableItem);

        Item item = new ImportedItemProvider().createItem
                (getImportedItemInputString(), taxableItem);
        assertEquals(expectedItem, item);
    }

    public String getImportedItemInputString() {
        return "1 imported music CD at 10";
    }

    @Test
    public void NonTaxableItemProviderShouldCreateNonTaxableItemFromInputString(){
        Item taxableItem = new TaxableItem(1, "book", 10.0);
        Item expectedItem = new NonTaxableItem(taxableItem);

        Item item = new NonTaxableItemProvider().createItem
                (getNonTaxableItemInputString(), taxableItem);

        assertEquals(expectedItem, item);
    }

    public String getNonTaxableItemInputString() {
        return "1 book at 5.00";
    }

    @Test
    public void NonTaxableImportedItemShouldBeCreatedFromInputStringOfNonTaxableImportedItem(){
        Item taxableItem = new TaxableItem(1, "imported book", 10.00);
        Item nonTaxableItem = new NonTaxableItem(taxableItem);
        Item expectedItem = new ImportedItem(nonTaxableItem);


        List<ItemProvider> providerList = new ArrayList<>();
        providerList.add(new TaxableItemProvider());
        providerList.add(new NonTaxableItemProvider());
        providerList.add(new ImportedItemProvider());

        Item item = null;
        for(ItemProvider provider : providerList){
            item = provider.createItem(getNonTaxableImportedItemInputString(), item);
        }

        assertEquals(expectedItem, item);
    }

    public String getNonTaxableImportedItemInputString() {
        return "1 imported book at 10.00";
    }
}
