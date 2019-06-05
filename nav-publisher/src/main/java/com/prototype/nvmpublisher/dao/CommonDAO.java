package com.prototype.nvmpublisher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class CommonDAO<T, ID> {
    protected Connection conn;
    protected PreparedStatement pstmt;
    public abstract T save(T t);
    public abstract T findById(ID id);
    public abstract T update(T t);
    public abstract void delete(T t);

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeStatement(){
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
