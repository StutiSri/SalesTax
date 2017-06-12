package org.tw.salestax;

import org.tw.inputreader.InputReader;
import org.tw.outputwriter.OutputWriter;

import java.util.ArrayList;

public class ReceiptGenerator {

    public static final String INVALID_INPUT_ERROR_MESSAGE = "Kindly re-enter the details of the basket in the following format : <quantity> <name " +
            "details> at <price>\n\n";

    public Receipt generateReceipt(ArrayList<String> inputItemList) {
        ArrayList<Item> items = new InputParser().createItemsFromList(inputItemList);
        if (items == null)
            return null;
        ArrayList<String> itemDetails = new ArrayList<>();
        for (Item item : items)
            itemDetails.add(item.toString());
        BillCalculator billCalculator = new BillCalculator(items);
        return new Receipt(items, billCalculator.getTotalSalesTax(), billCalculator.getTotalAmount());
    }

    public void start(InputReader inputReader, OutputWriter writer) {
        ArrayList<String> inputItemList;
        while (true) {
            inputItemList = inputReader.read();
            if (inputItemList == null)
                break;
            Receipt receipt = generateReceipt(inputItemList);
            if (receipt == null) {
                writer.write(INVALID_INPUT_ERROR_MESSAGE);
                continue;
            }
            writer.write(receipt.toString());
        }
        writer.write("Thank you!");
    }
}
