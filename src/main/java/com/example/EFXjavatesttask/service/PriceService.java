package com.example.EFXjavatesttask.service;

import com.example.EFXjavatesttask.model.Price;

import java.util.List;

public interface PriceService {

    void loadPrices(List<Price> prices);

    List<Price> getPrices();

    Price getLastPrice();
}
