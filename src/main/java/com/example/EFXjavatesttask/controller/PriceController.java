package com.example.EFXjavatesttask.controller;

import com.example.EFXjavatesttask.model.Price;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {

    @PostMapping("/publish")
    @ResponseBody
    public ResponseEntity<String> publishPrices(@RequestParam("price") List<Price> prices) throws IOException {
        return new ResponseEntity<>(prices.toString() + " published", HttpStatus.CREATED);
    }
}
