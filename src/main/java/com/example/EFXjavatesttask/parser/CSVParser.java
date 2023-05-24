package com.example.EFXjavatesttask.parser;

import com.example.EFXjavatesttask.model.Price;

import java.util.List;

public interface CSVParser {
    List<Price> parse(String csvString);
}
