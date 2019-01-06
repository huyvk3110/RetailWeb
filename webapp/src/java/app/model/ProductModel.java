/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.entity.Product;
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
public class ProductModel {
//    public static void main(String[] args) {
//        ProductModel model = new ProductModel();
//        List<Product> list = model.getProductByCatalog("CA008");
//        for (Product product : list) {
//            System.out.println("Product: " + product.getProductName());
//        }
//    }
    
    public List<Product> getProductByCatalog(String catId, int numProduct, boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getProductByCatalog(?,?,?)}");
            callST.setString(1, catId);
            if(numProduct >= 0) callST.setInt(2, numProduct);
            else callST.setNull(2, Types.INTEGER);
            callST.setBoolean(3, isAdmin);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<Product> getProductByCatalog(String catId) {
        return this.getProductByCatalog(catId, -1, false);
    }
    
    public List<Product> getProductByCatalog(String catId,int numPro) {
        return this.getProductByCatalog(catId, numPro, false);
    }
    
    public List<Product> getProductByCatalogAdmind(String catId) {
        return this.getProductByCatalog(catId, -1, true);
    }
    
    public List<Product> getLastestProduct(int numProduct) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getLastestProduct(?)}");
            if(numProduct >= 0) callST.setInt(1, numProduct);
            else callST.setNull(1, Types.INTEGER);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<Product> getSaleProduct(int numProduct) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getSaleProduct(?)}");
            if(numProduct >= 0) callST.setInt(1, numProduct);
            else callST.setNull(1, Types.INTEGER);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<Product> getHotProduct(int numProduct) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getHotProduct(?)}");
            if(numProduct >= 0) callST.setInt(1, numProduct);
            else callST.setNull(1, Types.INTEGER);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<Product> getHotSellingProduct(int numProduct) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getHotSellingProduct(?)}");
            if(numProduct >= 0) callST.setInt(1, numProduct);
            else callST.setNull(1, Types.INTEGER);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public Product getProductById(String productId) {
        Connection con = null;
        CallableStatement callST = null;
        Product product = new Product();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getProductById(?)}");
            callST.setString(1, productId);
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return product;
    }
    
    public List<Product> getProductBySpecification(String key, String value) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getProductBySpecification(?,?)}");
            callST.setString(1, key);
            callST.setString(2, value);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public List<Product> getProductBetweenPrice(float from, float to) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getProductBetweenPrice(?,?)}");
            callST.setFloat(1, from);
            callST.setFloat(2, to);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
    public int getNumberProduct() {
        Connection con = null;
        CallableStatement callST = null;
        int number = 0;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getNumberProduct()}");
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
    
    public int getNumberProductInCatalog(String catId) {
        Connection con = null;
        CallableStatement callST = null;
        int number = 0;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getNumberProductInCatalog(?)}");
            callST.setString(1, catId);
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
    
    public Product getProductByName(String name) {
        Connection con = null;
        CallableStatement callST = null;
        Product product = new Product();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getProductByName(?)}");
            callST.setString(1, name);
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                product.setProductId(rs.getString("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setPriceOutput(rs.getFloat("PriceOutput"));
                product.setDiscount(rs.getInt("Discount"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setQuality(rs.getInt("Quality"));
                product.setTitle(rs.getString("Title"));
                product.setGuarantee(rs.getInt("Guarantee"));
                product.setOneSwitchOne(rs.getInt("OneSwitchOne"));
                product.setDescription(rs.getString("Description"));
                product.setView(rs.getLong("View"));
                product.setSold(rs.getLong("Sold"));
                product.setCreated(rs.getDate("Created"));
                product.setStatus(rs.getBoolean("Status"));
                product.setCatalogId(rs.getString("CatalogId"));
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return product;
    }
}
