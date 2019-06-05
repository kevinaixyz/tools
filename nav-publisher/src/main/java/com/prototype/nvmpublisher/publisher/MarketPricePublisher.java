package com.prototype.nvmpublisher.publisher;

import com.prototype.nvmpublisher.portfolio.Portfolio;
import com.prototype.nvmpublisher.product.Stock;
import com.prototype.nvmpublisher.product.StockOption;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MarketPricePublisher {
    private final static ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
    final Random random = new Random();

    private Portfolio portfolio;
    private long commonStockDelta = 0;
    private long stockOptionDelta = 0;


    public MarketPricePublisher(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void init(){

            long currentTime = System.currentTimeMillis();

            for(Map.Entry<Object, Long> asset:portfolio.getAssets().entrySet()){
                System.out.println("Run On: "+ LocalDateTime.now());
                if(asset.getKey() instanceof Stock){
                    Stock stock = (Stock)asset.getKey();
                    MarketMaker<Stock> stockMarketMaker = new MarketMaker<>();
                    stockMarketMaker.setAsset(stock);
                    stockMarketMaker.setPortfolio(portfolio);
                    stockMarketMaker.setPriceGenerator(new StockPriceGenerator());
                    new Thread(stockMarketMaker).start();
//                    executor.scheduleWithFixedDelay(stockMarketMaker, delta, delta, TimeUnit.MILLISECONDS);
                }else if(asset.getKey() instanceof StockOption){
                    StockOption option = (StockOption)asset.getKey();
                    MarketMaker<StockOption> optionMarketMaker = new MarketMaker<>();
                    optionMarketMaker.setAsset(option);
                    optionMarketMaker.setPortfolio(portfolio);
                    optionMarketMaker.setPriceGenerator(new StockOptionPriceGenerator());
                    new Thread(optionMarketMaker).start();
//                    executor.scheduleWithFixedDelay(optionMarketMaker, delta, delta, TimeUnit.MILLISECONDS);
                }
            }

    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
