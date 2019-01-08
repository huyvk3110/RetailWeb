/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.entity.Catalog;
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
public class CatalogModel {
//    public static void main(String[] args) {
//        CatalogModel model = new CatalogModel();
//        List<Catalog> list = model.getAllMainCatalog();
//        for (Catalog catalog : list) {
//            System.out.println("Catalog: " + catalog.getCatalogName());
//        }
////        System.out.println("Product: " + model.getCatalogById("CA008").getCatalogName());
//    }
    
    public List<Catalog> getAllCatalog(int type,boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Catalog> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getAllCatalog(?,?)}");
            callST.setInt(1, type);
            callST.setBoolean(2, isAdmin);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getString("CatalogId"));
                catalog.setCatalogName(rs.getString("CatalogName"));
                catalog.setDescription(rs.getString("Description"));
                catalog.setView(rs.getLong("View"));
                catalog.setPriority(rs.getInt("Priority"));
                catalog.setStatus(rs.getBoolean("Status"));
                catalog.setParentId(rs.getString("ParentId"));
                list.add(catalog);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<Catalog> getAllCatalog() {
        return this.getAllCatalog(1,false);
    }
    
    public Catalog getCatalogById(String catId, boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        Catalog catalog = new Catalog();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getCatalogById(?,?)}");
            callST.setString(1, catId);
            callST.setBoolean(2, isAdmin);
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                catalog.setCatalogId(rs.getString("CatalogId"));
                catalog.setCatalogName(rs.getString("CatalogName"));
                catalog.setDescription(rs.getString("Description"));
                catalog.setView(rs.getLong("View"));
                catalog.setPriority(rs.getInt("Priority"));
                catalog.setStatus(rs.getBoolean("Status"));
                catalog.setParentId(rs.getString("ParentId"));
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return catalog;
    }
    
    public Catalog getCatalogById(String catId) {
        return this.getCatalogById(catId, false);
    }
    
    public int getNumberCatalog(int type) {
        Connection con = null;
        CallableStatement callST = null;
        int number = 0;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getNumberCatalog(?)}");
            callST.setInt(1, type);
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
    
    public int getNumberCatalog() {
        return this.getNumberCatalog(1);
    }
    
    public List<Catalog> getCatalogByParentId(String parentId, int type, boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Catalog> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getCatalogByParentId(?,?,?)}");
            if(parentId.equals("")) callST.setNull(1, Types.CHAR);
            else callST.setString(1, parentId);
            callST.setInt(2, type);
            callST.setBoolean(3, isAdmin);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getString("CatalogId"));
                catalog.setCatalogName(rs.getString("CatalogName"));
                catalog.setDescription(rs.getString("Description"));
                catalog.setView(rs.getLong("View"));
                catalog.setPriority(rs.getInt("Priority"));
                catalog.setStatus(rs.getBoolean("Status"));
                catalog.setParentId(rs.getString("ParentId"));
                list.add(catalog);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<Catalog> getCatalogByParentId(String parentId) {
        return this.getCatalogByParentId(parentId,1,false);
    }
    
    public List<Catalog> getAllMainCatalog() {
        return this.getCatalogByParentId("",1,false);
    }
}
