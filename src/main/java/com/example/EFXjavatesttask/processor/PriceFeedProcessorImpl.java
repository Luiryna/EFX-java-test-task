package com.example.EFXjavatesttask.processor;

import com.example.EFXjavatesttask.util.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceFeedProcessorImpl implements PriceFeedProcessor {

    private static final double BID_MARGIN = -0.001;
    private static final double ASK_MARGIN = 0.001;

    @Autowired
    private CSVParser csvParser;

    @Override
    public void onMessage(String message) {
        csvParser.parse(message).forEach(price -> {
            price.setBid(price.getBid() + (price.getBid() * BID_MARGIN));
            price.setAsk(price.getAsk() + (price.getAsk() * ASK_MARGIN));
            System.out.println(price);
        });
    }
}
