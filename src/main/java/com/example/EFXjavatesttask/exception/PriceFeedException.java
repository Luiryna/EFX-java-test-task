package com.example.EFXjavatesttask.exception;

import com.example.EFXjavatesttask.model.Price;

public class PriceFeedException extends RuntimeException {
    public PriceFeedException(String message) {
        super(message);
    }

}
