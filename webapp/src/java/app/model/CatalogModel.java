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
//        //Insert
//        Catalog catalog = new Catalog("CA099", "Huy", "Huy", 0, 5, true, "CA001");
//        boolean check = model.insertCatalog(catalog);
//        System.out.println("Check is " + check);
//        
//        //Get all
//        List<Catalog> list = model.getAllCatalog(true);
//        for (Catalog cat : list) {
//            System.out.println("Catalog: " + cat.getCatalogName());
//        }
//    }
    
    //**************************Select**************************//
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
                //Set parent name
                Catalog parent = getCatalogById(catalog.getParentId());
                catalog.setParentName((parent != null)? parent.getCatalogName():"");
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
                //Set parent name
                Catalog parent = getCatalogById(catalog.getParentId());
                catalog.setParentName((parent != null)? parent.getCatalogName():"");
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
                //Set parent name
                Catalog parent = getCatalogById(parentId);
                catalog.setParentName((parent != null)? parent.getCatalogName():"");
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
    
    //**************************Update**************************//
    public boolean toggleCatalog(String catalogId) {
        Connection con = null;
        CallableStatement callST = null;
        boolean result = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call toggleCatalog(?,?)}");
            callST.setString(1, catalogId);
            callST.registerOutParameter(2, Types.BOOLEAN);
            callST.execute();
            result = callST.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return result;
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
    
    //**************************Delete**************************//
    public boolean deleteCatalog(String catalogId) {
        Connection con = null;
        CallableStatement callST = null;
        boolean result = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call deleteCatalog(?,?)}");
            callST.setString(1, catalogId);
            callST.registerOutParameter(2, Types.BOOLEAN);
            callST.execute();
            result = callST.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return result;
    }
    
    //**************************Insert**************************//
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
}
