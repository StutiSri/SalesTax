package org.tw.salestax;

import org.junit.Test;
import org.tw.inputreader.ConsoleInputReader;
import org.tw.inputreader.InputReader;
import org.tw.outputwriter.ConsoleOutputWriter;
import org.tw.outputwriter.OutputWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.tw.constants.SalesTaxValues.SALES_TAX;

public class SalesTaxTest {
    @Test
    public void enumSalesTaxShouldReturnIntegerValue() {
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
    public void shouldReturnSalesTaxOfItem() {
        Item item = new Item(1, "music CD", false, 14.99);
        Double expectedSalesTax = 1.50;
        double delta = 0.001;

        assertEquals(expectedSalesTax, (Double) item.getSalesTax(), delta);
    }

    @Test
    public void shouldExemptSalesTaxOnItemsFromExemptedList() {
        Item item = new Item(1, "book", false, 15.99);
        Double expectedSalesTax = 0.0;

        assertEquals(expectedSalesTax, (Double) item.getSalesTax());
    }

    @Test
    public void shouldApplyAdditionalSalesTaxOnImportedItems() {
        Item item = new Item(1, "imported chocolate bar", true, 10.00);
        Double expectedSalesTax = 0.50;
        double delta = 0.001;

        assertEquals(expectedSalesTax, item.getSalesTax(), delta);
    }

    @Test
    public void shouldReturnTotalSalesTaxForItemsInShoppingBasket() {
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported box of chocolates at 10.00");
        inputItemList.add("1 imported bottle of perfume at 47.50");
        Double expectedTotalSalesTax = 7.65;

        ArrayList<Item> itemList = new ShoppingBasket().createItemsFromList(inputItemList);

        assertEquals(expectedTotalSalesTax, (Double) new BillCalculator(itemList).getTotalSalesTax());
    }

    @Test
    public void shouldReturnTotalAmountForShoppingBasket() {
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported bottle of perfume at 27.99");
        inputItemList.add("1 bottle of perfume at 18.99");
        inputItemList.add("1 packet of headache pills at 9.75");
        inputItemList.add("1 box of imported chocolates at 11.25");
        String expectedTotalAmount = "74.68";

        ArrayList<Item> itemList = new ShoppingBasket().createItemsFromList(inputItemList);

        assertEquals(expectedTotalAmount, String.format("%.2f", new BillCalculator(itemList).getTotalAmount
                ()));
    }

    @Test
    public void shouldReturnReceiptForShoppingBasket() {
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported bottle of perfume at 27.99");
        inputItemList.add("1 bottle of perfume at 18.99");
        inputItemList.add("1 packet of headache pills at 9.75");
        inputItemList.add("1 box of imported chocolates at 11.25");

        ArrayList<Item> items = new ShoppingBasket().createItemsFromList(inputItemList);
        TestReceipt expectedReceipt = new TestReceipt(items, 6.70, 74.68);

        assertEquals(expectedReceipt, new ReceiptGenerator().generateReceipt(inputItemList));
    }

    @Test
    public void shouldReturnReceiptForShoppingBasketInputByUser() {
        InputReader inputReader = new ConsoleInputReader(new BufferedReader(new StringReader("1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85\n\n")));

        String expectedReceipt = "1 book - 12.49\n" +
                "1 music CD - 16.49\n" +
                "1 chocolate bar - 0.85\n" +
                "Sales Taxes - 1.50\n" +
                "Total - 29.83\n\n" + "Thank you!";

        StringWriter stringWriter = new StringWriter();
        OutputWriter outputWriter = new ConsoleOutputWriter(new BufferedWriter(stringWriter));
        new ReceiptGenerator().start(inputReader, outputWriter);

        assertEquals(expectedReceipt, stringWriter.toString());
    }

    @Test
    public void shouldPrintErrorMessageForInvalidInputFormat() {
        InputReader inputReader = new ConsoleInputReader(new BufferedReader(new StringReader("1 book at 12.49\n" +
                "1 music CD for 14.99\n" +
                "1 chocolate bar at 0.85\n\n")));

        String expectedErrorMessage = "Kindly re-enter the details of the basket in the following format : <quantity> <name " +
                "details> at <price>\n\nThank you!";

        StringWriter stringWriter = new StringWriter();
        OutputWriter outputWriter = new ConsoleOutputWriter(new BufferedWriter(stringWriter));
        new ReceiptGenerator().start(inputReader, outputWriter);

        assertEquals(expectedErrorMessage, stringWriter.toString());
    }
}
