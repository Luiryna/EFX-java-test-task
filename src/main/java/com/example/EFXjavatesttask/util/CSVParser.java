package com.example.EFXjavatesttask.util;

import com.example.EFXjavatesttask.model.Price;

import java.util.List;

public interface CSVParser {
    List<Price> parse(String csvString);
}
