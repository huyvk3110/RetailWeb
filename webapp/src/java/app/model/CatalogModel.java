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
////        List<Catalog> list = model.getAllMainCatalog();
////        for (Catalog catalog : list) {
////            System.out.println("Catalog: " + catalog.getCatalogName());
////        }
//////        System.out.println("Product: " + model.getCatalogById("CA008").getCatalogName());
//        
//        Catalog catalog = new Catalog("CA012", "TEST haha", "TEST", 2, 1, true, "CA001");
//        if(model.updateCatalog(catalog)) {
//            System.out.println("Insert done");
//        }else {
//            System.out.println("Insert fails");
//        }
//    }
    
    public List<Catalog> getAllCatalog(boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Catalog> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getAllCatalog(?)}");
            callST.setBoolean(1, isAdmin);
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
        return this.getAllCatalog(false);
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
    
    public int getNumberCatalog() {
        Connection con = null;
        CallableStatement callST = null;
        int number = 0;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getNumberCatalog()}");
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
    
    public List<Catalog> getCatalogByParentId(String parentId, boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Catalog> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getCatalogByParentId(?,?)}");
            if(parentId.equals("")) callST.setNull(1, Types.CHAR);
            else callST.setString(1, parentId);
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
    
    public List<Catalog> getCatalogByParentId(String parentId) {
        return this.getCatalogByParentId(parentId,false);
    }
    
    public List<Catalog> getAllMainCatalog() {
        return this.getCatalogByParentId("",false);
    }
    
    public void toggleCatalog(String catalogId) {
        Connection con = null;
        CallableStatement callST = null;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call toggleCatalog(?)}");
            callST.setString(1, catalogId);
            callST.executeUpdate();
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
    }
    
    public void deleteCatalog(String catalogId) {
        Connection con = null;
        CallableStatement callST = null;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call deleteCatalog(?)}");
            callST.setString(1, catalogId);
            callST.executeUpdate();
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
    }
    
    public boolean insertCatalog(Catalog catalog) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call insertCatalog(?,?,?,?,?,?,?)}");
            callST.setString(1, catalog.getCatalogId());
            callST.setString(2, catalog.getCatalogName());
            callST.setString(3, catalog.getDescription());
            callST.setInt(4, catalog.getPriority());
            callST.setBoolean(5, catalog.isStatus());
            callST.setString(6, catalog.getParentId());
            callST.registerOutParameter(7, Types.BOOLEAN);
            callST.execute();
            check = callST.getBoolean(7);
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
    
    public boolean updateCatalog(Catalog catalog) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call updateCatalog(?,?,?,?,?,?,?)}");
            callST.setString(1, catalog.getCatalogId());
            callST.setString(2, catalog.getCatalogName());
            callST.setString(3, catalog.getDescription());
            callST.setInt(4, catalog.getPriority());
            callST.setBoolean(5, catalog.isStatus());
            callST.setString(6, catalog.getParentId());
            callST.registerOutParameter(7, Types.BOOLEAN);
            callST.executeUpdate();
            check = callST.getBoolean(7);
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
}
