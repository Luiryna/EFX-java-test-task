package com.example.EFXjavatesttask.model;


import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class Price {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String instrument;
    @CsvBindByPosition(position = 2)
    private double bid;
    @CsvBindByPosition(position = 3)
    private double ask;
    @CsvBindByPosition(position = 4)
    private String timestamp;

    public Price() {
    }

    public Price(int id, String instrument, double bid, double ask, String timestamp) {
        this.id = id;
        this.instrument = instrument;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getInstrument() {
        return instrument;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Price{" + "id=" + id + ", instrument='" + instrument + '\'' + ", bid=" + bid + ", ask=" + ask + ", timestamp=" + timestamp + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return id == price.id && Double.compare(price.bid, bid) == 0 && Double.compare(price.ask, ask) == 0 && Objects.equals(instrument, price.instrument) && Objects.equals(timestamp, price.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instrument, bid, ask, timestamp);
    }
}
