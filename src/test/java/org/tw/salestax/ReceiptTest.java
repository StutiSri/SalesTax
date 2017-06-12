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

import static org.junit.Assert.assertEquals;

public class ReceiptTest {
    @Test
    public void shouldReturnReceiptForAllItems(){
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported bottle of perfume at 27.99");
        inputItemList.add("1 bottle of perfume at 18.99");
        inputItemList.add("1 packet of headache pills at 9.75");
        inputItemList.add("1 box of imported chocolates at 11.25");

        ArrayList<Item> items = new InputParser().createItemsFromList(inputItemList);
        TestReceipt expectedReceipt = new TestReceipt(items, 6.70, 74.68);

        assertEquals(expectedReceipt, new ReceiptGenerator().generateReceipt(inputItemList));
    }

    @Test
    public void shouldReturnReceiptForItemsInputByUser(){
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
}
