package com.example.EFXjavatesttask;

import com.example.EFXjavatesttask.model.Price;
import com.example.EFXjavatesttask.processor.PriceFeedProcessor;
import com.example.EFXjavatesttask.parser.CSVParser;
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
    void lastFedPriceTest() {
        Price expectedPrice = new Price();
        expectedPrice.setId(106);
        expectedPrice.setInstrument("EUR/USD");
        expectedPrice.setBid(1.0989);
        expectedPrice.setAsk(1.2012);
        expectedPrice.setTimestamp("01-06-2020 12:01:01:003");
        priceFeedProcessor.onMessage("107,EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n" +
                "108,GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n" +
                "109,GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100\n" +
                "110,EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110\n" +
                "106,EUR/USD, 1.1000,1.2000,01-06-2020 12:01:03:001\n");
        Price actualPrice = priceFeedProcessor.getLastPrice();
        assertEquals(expectedPrice, actualPrice);
    }

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
    void feedPriceTest() {
        priceFeedProcessor.onMessage("106,EUR/USD,1.1000,1.2000,01-06-2020 12:01:01:001");
        System.err.println(priceFeedProcessor.getLastPrice().toString());
    }


}
