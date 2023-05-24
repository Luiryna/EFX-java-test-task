package com.example.EFXjavatesttask.controller;

import com.example.EFXjavatesttask.model.Price;
import com.example.EFXjavatesttask.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {

    @Autowired
    private PriceService service;

    @PostMapping("/publish")
    @ResponseBody
    public ResponseEntity<String> publishPrices(@RequestParam("price") List<Price> prices) {
        service.loadPrices(prices);
        return ResponseEntity.status(HttpStatus.CREATED).body(prices.toString() + " published");
    }
}
