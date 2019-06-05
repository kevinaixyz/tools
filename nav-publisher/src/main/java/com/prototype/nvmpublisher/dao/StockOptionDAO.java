package com.prototype.nvmpublisher.dao;

import com.prototype.nvmpublisher.product.AssetType;
import com.prototype.nvmpublisher.product.Stock;
import com.prototype.nvmpublisher.product.StockOption;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockOptionDAO extends CommonDAO<StockOption, String>{

    @Override
    public StockOption save(StockOption stockOption) {
        return null;
    }

    @Override
    public StockOption findById(String id) {
        StockOption stockOption = null;
        if(conn!=null){
            try {
                String sql = "select * from stock_option where isin=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                rs.setFetchSize(1);
                stockOption = new StockOption();
                while (rs.next()) {
                    stockOption.setIsin(rs.getString("isin"));
                    stockOption.setStockTicker(rs.getString("stock_ticker"));
                    stockOption.setType(AssetType.STOCK_OPTION);
                    stockOption.setStartPrice(rs.getDouble("start_price"));
                    stockOption.setLongShort(rs.getString("long_short"));
                    stockOption.setStrikePrice(rs.getDouble("sd"));
                    stockOption.setStartDate(rs.getDate("start_date").toLocalDate());
                    stockOption.setMaturityDate(rs.getDate("maturity_date").toLocalDate());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stockOption;
    }

    @Override
    public StockOption update(StockOption stockOption) {
        return null;
    }

    @Override
    public void delete(StockOption stockOption) {

    }
}
