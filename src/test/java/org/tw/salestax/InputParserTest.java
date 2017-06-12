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

public class InputParserTest {

    @Test
    public void shouldCreateItemsFromInput() {
        InputParser inputParser = new InputParser();
        ArrayList<String> inputItemList = new ArrayList<>();
        inputItemList.add("1 imported book at 12.49");
        ArrayList<Item> expectedItems = new ArrayList<>();
        expectedItems.add(new Item(1, "imported book", true, 12.49));

        ArrayList<Item> items = inputParser.createItemsFromList(inputItemList);

        assertEquals(expectedItems, items);
    }

    @Test
    public void shouldPrintErrorMessageForInvalidInputFormat(){
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
