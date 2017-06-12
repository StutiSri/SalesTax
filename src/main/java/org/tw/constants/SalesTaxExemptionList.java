package org.tw.constants;

public enum SalesTaxExemptionList {
    chocolate, pill, book;

    public static SalesTaxExemptionList fromString(String parameter) {
        for (SalesTaxExemptionList exemptedProduct : SalesTaxExemptionList.values()) {
            if (parameter.contains(exemptedProduct.toString()))
                return exemptedProduct;
        }
        return null;
    }
}
