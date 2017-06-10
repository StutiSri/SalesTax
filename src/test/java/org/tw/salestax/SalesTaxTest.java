package org.tw.salestax;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.tw.salestax.SalesTaxValues.SALES_TAX;

public class SalesTaxTest {
    @Test
    public void enumSalesTaxShouldReturnIntegerValue(){
        assertEquals(10, SALES_TAX.getValue());
    }

    @Test
    public void shouldCreateItemsFromInput(){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported book at 12.49");
        ArrayList<Item> expectedItems = new ArrayList<>();
        expectedItems.add(new Item(1, "imported book", false, 12.49));

        ArrayList<Item> items = shoppingBasket.createItemsFromList(inputItemList);

        assertEquals(expectedItems,items);

        //assertTrue(items.equals(expectedItems));
    }
}
