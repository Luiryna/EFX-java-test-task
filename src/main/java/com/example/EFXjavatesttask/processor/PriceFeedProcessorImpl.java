package com.example.EFXjavatesttask.processor;

import com.example.EFXjavatesttask.controller.PriceController;
import com.example.EFXjavatesttask.exception.PriceFeedException;
import com.example.EFXjavatesttask.model.Price;
import com.example.EFXjavatesttask.parser.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PriceFeedProcessorImpl implements PriceFeedProcessor {

    private List<Price> priceList = new ArrayList<>();

    private static final double BID_MARGIN = -0.001;
    private static final double ASK_MARGIN = 0.001;

    @Autowired
    private CSVParser csvParser;

    @Autowired
    private PriceController priceController;

    @Override
    public void onMessage(String message) {
        priceList = feedPrices(message);
        try {
            priceController.publishPrices(priceList);
        } catch (IOException e) {
            throw new PriceFeedException("Error while publishing prices: " + e.getMessage());
        }
    }

    public Price getLastPrice() {
        return priceList.get(priceList.size() - 1);
    }

    private List<Price> feedPrices(String message) {
        List<Price> priceList = new ArrayList<>();
        csvParser.parse(message).forEach(price -> {
            price.setBid(price.getBid() + (price.getBid() * BID_MARGIN));
            price.setAsk(price.getAsk() + (price.getAsk() * ASK_MARGIN));
            priceList.add(price);
        });
        return priceList;
    }
}
