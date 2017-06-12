package org.tw.salestax;

import org.junit.Test;
import org.tw.constants.SalesTaxExemptionList;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void shouldReturnCalculatedSalesTaxOfItem(){
        Item item = new Item(1, "music CD", false, 14.99);
        Double expectedSalesTax = 1.50;
        double delta = 0.001;

        assertEquals(expectedSalesTax, item.getSalesTax(), delta);
    }

    @Test
    public void shouldExemptSalesTaxOnItemsFromExemptedList(){
        Item item = new Item(1, SalesTaxExemptionList.book.toString(), false, 15.99);
        Double expectedSalesTax = 0.0;

        assertEquals(expectedSalesTax, (Double) item.getSalesTax());
    }

    @Test
    public void shouldApplyAdditionalSalesTaxOnImportedItems(){
        Item item = new Item(1, "imported chocolate bar", true, 10.00);
        Double expectedSalesTax = 0.50;
        double delta = 0.001;

        assertEquals(expectedSalesTax, item.getSalesTax(), delta);
    }
}
