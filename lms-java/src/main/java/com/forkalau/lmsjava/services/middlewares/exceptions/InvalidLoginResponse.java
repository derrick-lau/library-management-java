package com.forkalau.lmsjava.services.middlewares.exceptions;

public class InvalidLoginResponse {
    private String barcode;
    private String password;

    public InvalidLoginResponse() {
        this.barcode = "Invalid Username";
        this.password = "Invalid Password";
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}