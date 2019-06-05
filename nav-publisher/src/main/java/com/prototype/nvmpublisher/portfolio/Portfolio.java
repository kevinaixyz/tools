package com.prototype.nvmpublisher.portfolio;

import com.prototype.nvmpublisher.calc.MarketValueCalculator;
import com.prototype.nvmpublisher.product.Asset;
import com.prototype.nvmpublisher.product.Stock;
import com.prototype.nvmpublisher.product.StockOption;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private final Map<Object, Long> assets = new HashMap<>();
    private double netMarketValue;

    public <A extends Asset> void addAsset(A a, long vol){
        assets.put(a, vol);
    }

    public double getNetMarketValue(){
        return netMarketValue;
    }

    public static void setNetMarketValue(double netMarketValue) {
        netMarketValue = netMarketValue;
    }

    public Map<Object, Long> getAssets() {
        return assets;
    }

    public void showNetAssetValue(){
        netMarketValue = 0d;
        for(Map.Entry<Object, Long> entry:assets.entrySet()){
            if(entry.getKey()instanceof Stock){
                Stock stock = (Stock)entry.getKey();
                netMarketValue += MarketValueCalculator.calculate(entry.getValue(), stock.getMarketPrice());
                System.out.println(stock.showPrice());
            }else if(entry.getKey()instanceof StockOption){
                StockOption option = (StockOption)entry.getKey();
                netMarketValue += MarketValueCalculator.calculate(entry.getValue(), option.getMarketPrice());
                System.out.println(option.showPrice());
            }
        }
        System.out.println("Total Net Asset Value: "+netMarketValue);
    }
}
