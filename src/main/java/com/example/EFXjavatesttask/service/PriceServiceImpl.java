package com.example.EFXjavatesttask.service;

import com.example.EFXjavatesttask.model.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    public List<Price> prices;

    @Override
    public void loadPrices(List<Price> prices) {
        this.prices = prices;
    }
    @Override
    public List<Price> getPrices() {
        return prices;
    }

    @Override
    public Price getLastPrice() {
        return prices.get(prices.size() - 1);
    }
}
