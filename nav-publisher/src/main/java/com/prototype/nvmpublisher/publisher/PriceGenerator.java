package com.prototype.nvmpublisher.publisher;

public abstract class PriceGenerator {
    public abstract double genPrice(double initPrice, long delta);
}
