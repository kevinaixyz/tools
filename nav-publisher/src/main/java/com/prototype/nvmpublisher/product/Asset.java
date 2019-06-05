package com.prototype.nvmpublisher.product;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class Asset {
    protected long lastUpdatedMisc;
    protected double startPrice;
    protected AssetType type;
    protected String ticker;
    protected double marketPrice;
    public Asset(){}

    public String showPrice(){
        StringBuilder sb = new StringBuilder();
        sb.append(ticker);
        sb.append(": ");
        sb.append(marketPrice);
        sb.append("last updated on: ");
        sb.append(LocalDateTime.ofInstant(Instant.ofEpochMilli(lastUpdatedMisc), ZoneId.systemDefault()).toString());
        return sb.toString();
    }


    public AssetType getType() {
        return type;
    }

    public void setType(AssetType type) {
        this.type = type;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public long getLastUpdatedMisc() {
        return lastUpdatedMisc;
    }

    public void setLastUpdatedMisc(long lastUpdatedMisc) {
        this.lastUpdatedMisc = lastUpdatedMisc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return type == asset.type &&
                Objects.equals(ticker, asset.ticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, ticker);
    }
}
