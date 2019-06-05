package com.prototype.nvmpublisher.product;

import java.time.LocalDate;

public class StockOption extends Asset{
    private String isin;
    private String stockTicker;
    private String longShort;
    private double strikePrice;
    private LocalDate maturityDate;
    private LocalDate startDate;

    public StockOption(){
        super();
    }
    public StockOption(String isin, String ticker, String longShort, double strikePrice, LocalDate startDate, LocalDate maturityDate){
        super();
        this.type = AssetType.STOCK_OPTION;
        this.isin = isin;
        this.ticker = ticker;
        this.longShort = longShort;
        this.strikePrice = strikePrice;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public String getLongShort() {
        return longShort;
    }

    public void setLongShort(String longShort) {
        this.longShort = longShort;
    }

    public double getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(double strikePrice) {
        this.strikePrice = strikePrice;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
