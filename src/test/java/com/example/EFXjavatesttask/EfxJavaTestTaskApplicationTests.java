package com.example.EFXjavatesttask;

import com.example.EFXjavatesttask.model.Price;
import com.example.EFXjavatesttask.processor.PriceFeedProcessor;
import com.example.EFXjavatesttask.util.CSVParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class EfxJavaTestTaskApplicationTests {

    @Autowired
    private CSVParser csvParser;

    @Autowired
    private PriceFeedProcessor priceFeedProcessor;

    @Test
    void parserTest() {
        String csvString = "106,EUR/USD,1.1000,1.2000,01-06-2020 12:01:01:001";
        Price expectedPrice = new Price();
        expectedPrice.setId(106);
        expectedPrice.setInstrument("EUR/USD");
        expectedPrice.setBid(1.1000);
        expectedPrice.setAsk(1.2000);
        expectedPrice.setTimestamp("01-06-2020 12:01:01:001");
        Price actualPrice = csvParser.parse(csvString).get(0);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void messageTest() {
        priceFeedProcessor.onMessage("106,EUR/USD,1.1000,1.2000,01-06-2020 12:01:01:001");
    }


}
