package org.tw.salestax;

public class TestItem extends Item{
    public TestItem(int quantity, String name, boolean isImported, double shelfPrice) {
        super(quantity, name, isImported, shelfPrice);
    }

    @Override
    public boolean equals(Object obj) {
        return super.toString().equals(obj.toString());
    }
}
