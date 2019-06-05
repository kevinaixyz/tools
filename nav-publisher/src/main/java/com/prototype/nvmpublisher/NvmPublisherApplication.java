package com.prototype.nvmpublisher;

import com.prototype.nvmpublisher.dao.NavConnection;
import com.prototype.nvmpublisher.portfolio.Portfolio;
import com.prototype.nvmpublisher.publisher.MarketPricePublisher;
import com.prototype.nvmpublisher.reader.PortfolioFileReader;

public class NvmPublisherApplication {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();
        PortfolioFileReader.getInstance().initPortfolio(portfolio);
        MarketPricePublisher pricePublisher = new MarketPricePublisher(portfolio);
        pricePublisher.init();
        NavConnection dbConn = new NavConnection();
        dbConn.init();
    }

}
