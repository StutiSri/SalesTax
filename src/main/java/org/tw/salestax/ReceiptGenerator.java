package org.tw.salestax;

import org.tw.inputreader.InputReader;
import org.tw.outputwriter.OutputWriter;

import java.util.ArrayList;

public class ReceiptGenerator {
    public Receipt generateReceipt(ArrayList<String> inputItemList){
        ArrayList<Item> items = new ShoppingBasket().createItemsFromList(inputItemList);
        ArrayList<String> itemDetails = new ArrayList<>();
        for(Item item : items)
            itemDetails.add(item.toString());
        BillCalculator billCalculator = new BillCalculator();
        return new Receipt(items, billCalculator.calculateTotalSalesTax(items), billCalculator
                .calculateTotalAmount(items));
    }

    public void start(InputReader inputReader, OutputWriter writer){
        ArrayList<String> inputItemList = inputReader.read();
        while(inputItemList!=null){
            writer.write(generateReceipt(inputItemList).toString());
            inputItemList = inputReader.read();
        }
        writer.write("Thank you!");
    }
}
