/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.entity.News;
import app.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huy
 */
public class NewModel {
    public static void main(String[] args) {
        NewModel model = new NewModel();
        List<News> list = model.getAllNew();
        for (News news : list) {
            System.out.println("News: " + news.getTitle());
        }
        System.out.println("Number: " + model.getNumberNews());
    }
    
    public List<News> getAllNew(boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<News> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getAllNew(?)}");
            callST.setBoolean(1, isAdmin);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                News news = new News();
                news.setNewsId(rs.getString("NewsId"));
                news.setMainPicture(rs.getString("MainPicture"));
                news.setTitle(rs.getString("Title"));
                news.setDescription(rs.getString("Description"));
                news.setPriority(rs.getInt("Priority"));
                news.setCreated(rs.getDate("Created"));
                news.setStatus(rs.getBoolean("Status"));
                news.setProductId(rs.getString("ProductId"));
                list.add(news);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<News> getAllNew() {
        return this.getAllNew(false);
    }
    
    public List<News> getProductNew(String proId,boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<News> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getProductNew(?,?)}");
            callST.setString(1, proId);
            callST.setBoolean(2, isAdmin);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                News news = new News();
                news.setNewsId(rs.getString("NewsId"));
                news.setMainPicture(rs.getString("MainPicture"));
                news.setTitle(rs.getString("Title"));
                news.setDescription(rs.getString("Description"));
                news.setPriority(rs.getInt("Priority"));
                news.setCreated(rs.getDate("Created"));
                news.setStatus(rs.getBoolean("Status"));
                news.setProductId(rs.getString("ProductId"));
                list.add(news);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<News> getProductNew(String proId) {
        return this.getProductNew(proId,false);
    }
    
    public List<News> getLastestNew(int numNew) {
        Connection con = null;
        CallableStatement callST = null;
        List<News> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getLastestNew(?)}");
            if(numNew >= 0) callST.setInt(1, numNew);
            else callST.setNull(1, Types.INTEGER);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                News news = new News();
                news.setNewsId(rs.getString("NewsId"));
                news.setMainPicture(rs.getString("MainPicture"));
                news.setTitle(rs.getString("Title"));
                news.setDescription(rs.getString("Description"));
                news.setPriority(rs.getInt("Priority"));
                news.setCreated(rs.getDate("Created"));
                news.setStatus(rs.getBoolean("Status"));
                news.setProductId(rs.getString("ProductId"));
                list.add(news);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public int getNumberNews() {
        Connection con = null;
        CallableStatement callST = null;
        int number = 0;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getNumberNews(?)}");
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return number;
    }
}
