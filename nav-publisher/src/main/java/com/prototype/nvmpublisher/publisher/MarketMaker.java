package com.prototype.nvmpublisher.publisher;

import com.prototype.nvmpublisher.portfolio.Portfolio;
import com.prototype.nvmpublisher.product.Asset;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class MarketMaker<T extends Asset> implements Runnable {
    final long minSleepTime=500L;
    final long maxSleepTime=2000L;
    protected T asset;
    protected long delta;
    protected PriceGenerator priceGenerator;
    private Portfolio portfolio;
    public long getDelta() {
        return delta;
    }
    public void setDelta(long delta) {
        this.delta = delta;
    }

    public PriceGenerator getPriceGenerator() {
        return priceGenerator;
    }

    public void setPriceGenerator(PriceGenerator priceGenerator) {
        this.priceGenerator = priceGenerator;
    }

    @Override
    public void run() {
        while(true){
            long delta = ThreadLocalRandom.current().nextLong(minSleepTime, maxSleepTime);
            System.out.println("Wait for "+(delta/1000.0)+ " seconds");
            double curPrice = priceGenerator.genPrice(asset.getStartPrice(),delta);
            if(curPrice!=asset.getStartPrice()){
                asset.setMarketPrice(curPrice);
                portfolio.showNetAssetValue();
                System.out.println(asset.getTicker()+" Updated On: "+ LocalDateTime.now());
            }
            try {
                Thread.sleep(delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public T getAsset() {
        return asset;
    }

    public void setAsset(T asset) {
        this.asset = asset;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
