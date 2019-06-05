package com.prototype.nvmpublisher.dao;

import com.prototype.nvmpublisher.product.AssetType;
import com.prototype.nvmpublisher.product.Stock;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockDAO extends CommonDAO<Stock, String>{


    @Override
    public Stock save(Stock stock) {
        return null;
    }

    @Override
    public Stock findById(String s) {
        Stock stock = null;
        if(conn!=null){
            try {
                String sql = "select * from stock where ticker=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, s);
                ResultSet rs = pstmt.executeQuery();
                rs.setFetchSize(1);
                stock = new Stock();
                while (rs.next()) {
                    stock.setTicker(rs.getString("ticker"));
                    stock.setStockCode(rs.getString("stockCode"));
                    stock.setType(AssetType.STOCK);
                    stock.setStartPrice(rs.getDouble("start_price"));
                    stock.setExpectedPrice(rs.getDouble("exp_price"));
                    stock.setStandardDiv(rs.getDouble("sd"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stock;
    }

    @Override
    public Stock update(Stock stock) {
        return null;
    }

    @Override
    public void delete(Stock stock) {

    }
}
