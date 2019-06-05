package com.prototype.nvmpublisher.product;

public class Stock extends Asset{
    private String stockCode;
    private double expectedPrice;
    private double standardDiv;

    public Stock(){
        super();
    }
    public Stock(String ticker, double marketPrice){
        super();
        this.ticker = ticker;
        this.marketPrice = marketPrice;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public double getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public double getStandardDiv() {
        return standardDiv;
    }

    public void setStandardDiv(double standardDiv) {
        this.standardDiv = standardDiv;
    }
}
