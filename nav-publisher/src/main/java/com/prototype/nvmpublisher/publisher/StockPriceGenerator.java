package com.prototype.nvmpublisher.publisher;

public class StockPriceGenerator extends PriceGenerator {

    @Override
    public double genPrice(double initPrice, long delta) {
        return delta/100.0;
    }
}
