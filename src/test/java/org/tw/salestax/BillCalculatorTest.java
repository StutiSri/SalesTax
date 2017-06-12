package org.tw.salestax;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.tw.constants.SalesTaxValues.SALES_TAX;

public class BillCalculatorTest {
    @Test
    public void enumSalesTaxShouldReturnIntegerValue(){
        assertEquals(10, SALES_TAX.getValue());
    }

    @Test
    public void shouldReturnTotalSalesTaxForItemsInShoppingBasket(){
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported box of chocolates at 10.00");
        inputItemList.add("1 imported bottle of perfume at 47.50");
        Double expectedTotalSalesTax = 7.65;

        ArrayList<Item> itemList = new InputParser().createItemsFromList(inputItemList);

        assertEquals(expectedTotalSalesTax, (Double)new BillCalculator(itemList).getTotalSalesTax());
    }

    @Test
    public void shouldReturnTotalAmountForItems(){
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported bottle of perfume at 27.99");
        inputItemList.add("1 bottle of perfume at 18.99");
        inputItemList.add("1 packet of headache pills at 9.75");
        inputItemList.add("1 box of imported chocolates at 11.25");
        String expectedTotalAmount = "74.68";

        ArrayList<Item> itemList = new InputParser().createItemsFromList(inputItemList);

        assertEquals(expectedTotalAmount, String.format("%.2f", new BillCalculator(itemList).getTotalAmount()));
    }




}
