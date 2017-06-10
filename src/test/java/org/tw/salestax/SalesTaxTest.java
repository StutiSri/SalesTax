package org.tw.salestax;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.tw.constants.SalesTaxValues.SALES_TAX;

public class SalesTaxTest {
    @Test
    public void enumSalesTaxShouldReturnIntegerValue(){
        assertEquals(10, SALES_TAX.getValue());
    }

    @Test
    public void shouldCreateItemsFromInput() {
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported book at 12.49");
        ArrayList<Item> expectedItems = new ArrayList<>();
        expectedItems.add(new Item(1, "imported book", true, 12.49));

        ArrayList<Item> items = shoppingBasket.createItemsFromList(inputItemList);

        assertEquals(expectedItems, items);
    }

    @Test
    public void shouldReturnSalesTaxOfItem(){
        Item item = new Item(1, "music CD", false, 14.99);
        Double expectedSalesTax = 1.50;
        double delta = 0.001;

        assertEquals(expectedSalesTax, (Double) item.getSalesTax(), delta);
    }

    @Test
    public void shouldExemptSalesTaxOnItemsFromExemptedList(){
        Item item = new Item(1, "book", false, 15.99);
        Double expectedSalesTax = 0.0;

        assertEquals(expectedSalesTax, (Double) item.getSalesTax());
    }

    @Test
    public void shouldApplyAdditionalSalesTaxOnImportedItems(){
        Item item = new Item(1, "imported chocolate bar", true, 10.00);
        Double expectedSalesTax = 0.50;
        double delta = 0.001;

        assertEquals(expectedSalesTax, (Double) item.getSalesTax(), delta);
    }

    @Test
    public void shouldReturnTotalSalesTaxForItemsInShoppingBasket(){
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported box of chocolates at 10.00");
        inputItemList.add("1 imported bottle of perfume at 47.50");
        Double expectedTotalSalesTax = 7.65;

        ArrayList<Item> itemList = new ShoppingBasket().createItemsFromList(inputItemList);

        assertEquals(expectedTotalSalesTax, (Double)new SalesTaxCalculator().calculateTotalSalesTax(itemList));
    }

    @Test
    public void shouldReturnTotalAmountForShoppingBasket(){
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported bottle of perfume at 27.99");
        inputItemList.add("1 bottle of perfume at 18.99");
        inputItemList.add("1 packet of headache pills at 9.75");
        inputItemList.add("1 box of imported chocolates at 11.25");
        String expectedTotalAmount = "74.68";

        ArrayList<Item> itemList = new ShoppingBasket().createItemsFromList(inputItemList);
        assertEquals(expectedTotalAmount, new SalesTaxCalculator().calculateTotalAmount(itemList));
    }
}
