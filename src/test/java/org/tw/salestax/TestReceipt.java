package org.tw.salestax;

import java.util.ArrayList;

public class TestReceipt extends Receipt {

    public TestReceipt(ArrayList<Item> items, double salesTax, double totalAmount) {
        super(items, salesTax, totalAmount);

    }

    @Override
    public boolean equals(Object obj) {
        return super.toString().equals(obj.toString());
    }
}
