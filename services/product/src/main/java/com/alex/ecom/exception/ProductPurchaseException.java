package com.alex.ecom.exception;

public class ProductPurchaseException extends RuntimeException{
    public ProductPurchaseException(String oneOrMoreProductsUndefined) {
        super(oneOrMoreProductsUndefined);
    }
}
