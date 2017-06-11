package org.tw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tw.pojo.ItemData;
import org.tw.pojo.ReceiptData;
import org.tw.pojo.ShoppingBasketData;
import org.tw.salestax.Item;
import org.tw.salestax.Receipt;
import org.tw.salestax.ReceiptGenerator;

import java.util.ArrayList;

@RestController
public class SalesTaxRequestController {

    @RequestMapping("/")
    public String test(){
        return "Heya! Welcome to Sales Tax Application!";
    }

    @RequestMapping(value = "/generateReceipt", method = RequestMethod.POST)
    public ResponseEntity<ReceiptData> generateReceipt(@RequestBody ShoppingBasketData shoppingBasketData){
        ArrayList<String> inputItemList = getInputItemList(shoppingBasketData);
        Receipt receipt = new ReceiptGenerator().generateReceipt(inputItemList);
        return new ResponseEntity<>(getReceiptData(receipt), HttpStatus.OK);
    }

    private ArrayList<String> getInputItemList(ShoppingBasketData shoppingBasketData) {
        ArrayList<ItemData> itemData = shoppingBasketData.getItemData();
        ArrayList<String> inputItems = new ArrayList<>();
        for(ItemData item : itemData)
            inputItems.add(item.getItemDetails());
        return inputItems;
    }

    private ReceiptData getReceiptData(Receipt receipt) {
        ReceiptData receiptData = new ReceiptData();
        ArrayList<Item> items = receipt.getItems();
        ArrayList<ItemData> itemDetails = new ArrayList<>();
        for(Item item : items){
            ItemData itemData = new ItemData();
            itemData.setItemDetails(item.toString());
            itemDetails.add(itemData);
        }
        receiptData.setItemData(itemDetails);
        receiptData.setSalesTax(receipt.getSalesTax());
        receiptData.setTotalAmount(receipt.getTotalAmount());
        return receiptData;
    }
}
