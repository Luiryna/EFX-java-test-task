package com.example.EFXjavatesttask.util;

import com.example.EFXjavatesttask.model.Price;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.Collections;
import java.util.List;

@Component
public class CSVParserImpl implements CSVParser {
    public List<Price> parse(String csvString) {
        try {
            return new CsvToBeanBuilder<Price>(new StringReader(csvString)).withType(Price.class).build().parse();
        } catch (Exception e) {
            System.err.println("Error while parsing CSV string: " + e.getMessage());
        }
        return Collections.emptyList();
    }

}
