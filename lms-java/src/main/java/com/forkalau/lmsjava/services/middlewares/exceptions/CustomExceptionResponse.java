package com.forkalau.lmsjava.services.middlewares.exceptions;

public class CustomExceptionResponse {
    private String barcode;

    public CustomExceptionResponse(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
