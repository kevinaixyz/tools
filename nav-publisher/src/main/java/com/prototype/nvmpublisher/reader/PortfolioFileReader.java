package com.prototype.nvmpublisher.reader;

import com.prototype.nvmpublisher.dao.StockDAO;
import com.prototype.nvmpublisher.portfolio.Portfolio;
import com.prototype.nvmpublisher.product.AssetType;
import com.prototype.nvmpublisher.product.Stock;
import com.prototype.nvmpublisher.product.StockOption;

import java.io.*;
import java.nio.file.Paths;

public class PortfolioFileReader {
    File portfolioFile;
    private PortfolioFileReader instance;
    private StockDAO stockDAO;

    private PortfolioFileReader(){
        try {
            String filePath = NavConfig.get("portfolio.file.path");
            String fileName = NavConfig.get("portfolio.file.name");

            if(filePath!=null&&fileName!=null){
                portfolioFile = new File(Paths.get(filePath).toFile().getCanonicalPath()+File.separator+fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static PortfolioFileReader getInstance(){
        return new PortfolioFileReader();
    }
    public File getPortfolioFile(){
        return portfolioFile;
    }

    public void initPortfolio(Portfolio portfolio){
        File portfolioFile = PortfolioFileReader.getInstance().getPortfolioFile();
        if(portfolioFile!=null){
            try {
                BufferedReader r = new BufferedReader(new FileReader(portfolioFile));
                String line= null;
                int row = 0;
                try {
                    while((line = r.readLine())!=null){
                        if(row==0){
                            row++;
                            continue;
                        }
                        String[] temp = line.split(",");
                        if(temp!=null&&temp.length==4){
                            String type = temp[1].trim();
                            switch (type.toLowerCase()){
                                case "stock":
                                    Stock stock = new Stock();
                                    stock.setTicker(temp[0].trim());
                                    stock.setType(AssetType.STOCK);

                                    portfolio.addAsset(stock, Long.parseLong(temp[2].trim()));
                                    break;
                                case "stock option":
                                    StockOption stockOption = new StockOption();
                                    portfolio.addAsset(stockOption, Long.parseLong(temp[2].trim()));
                                    break;
                            }
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
