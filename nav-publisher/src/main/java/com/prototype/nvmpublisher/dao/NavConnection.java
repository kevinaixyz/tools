package com.prototype.nvmpublisher.dao;

import com.prototype.nvmpublisher.reader.NavConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NavConnection {
    private Connection conn;
    public void registerDB(){
        String driverStr = NavConfig.get("datasource.driver-class-name");
        String username = NavConfig.get("datasource.username");
        String pwd = NavConfig.get("datasource.password");
        try {
            if(driverStr!=null){
                Class.forName(driverStr);
                conn = DriverManager.getConnection ("jdbc:h2:~/nav", username, pwd);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void init(){
        registerDB();
        initData();
    }
    public void initData(){

        PreparedStatement pstmt = null;
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("data.sql")));
            String line = null;
            while((line = in.readLine())!=null){
                if(conn!=null){
                    pstmt = conn.prepareStatement(line);
                    pstmt.executeUpdate();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() throws SQLException {
        if(conn!=null){
            conn.close();
        }
    }
}
