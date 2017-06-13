package org.tw.inputreader;

import org.tw.pojo.ItemData;
import org.tw.pojo.ShoppingBasketData;
import org.tw.salestax.Item;

import java.util.ArrayList;

public class WebInputReader implements InputReader {

    private final ShoppingBasketData shoppingBasketData;

    public WebInputReader(ShoppingBasketData shoppingBasketData){

        this.shoppingBasketData = shoppingBasketData;
    }

    @Override
    public ArrayList<String> read() {
        ArrayList<String> inputItemList = new ArrayList<>();
        ArrayList<ItemData> itemDataArrayList = shoppingBasketData.getItemData();
        for (ItemData itemData : itemDataArrayList){
            inputItemList.add(itemData.getItemDetails());
        }
        return inputItemList;
    }
}
