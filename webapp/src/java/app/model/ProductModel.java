/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.entity.Product;
import app.entity.Specification;
import app.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author huy
 */
public class ProductModel {
//    public static void main(String[] args) {
//        ProductModel model = new ProductModel();
//        Product pro = new Product("PM00007", "New", 100000, 10, 1000, 100, "Hahahaha", 365, 10, "Hahaha", 0, 0, new Date(2018, 10, 31), true, "CA011");
//        model.insertProduct(pro);
//        List<Product> list = model.getAllProduct(true);
//        for (Product product : list) {
//            System.out.println("Product: " + product.getProductName());
//        }
//    }
    CatalogModel catalogModel = null;
    
    public ProductModel() {
        catalogModel = new CatalogModel();
    }

    //****************************Select****************************//
    public List<Product> getAllProduct(boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Product> list = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call getAllProduct(?)}");
            callST.setBoolean(1, isAdmin);
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), isAdmin));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return list;
    }
    
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), isAdmin));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
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
                product.setCatalogName(catalogModel.getCatalogById(rs.getString("CatalogId")).getCatalogName());
                product.setSpecification(selectSpecificationByProductId(product.getProductId(), false));
            }
        } catch (SQLException e) {
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return product;
    }
    
    //****************************Insert****************************//
    public boolean insertProduct(Product product) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call createProduct(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            callST.setString(1, product.getProductId());
            callST.setString(2, product.getProductName());
            callST.setFloat(3, product.getPriceOutput());
            callST.setInt(4, product.getDiscount());
            callST.setInt(5, product.getQuantity());
            callST.setInt(6, product.getQuality());
            callST.setString(7, product.getTitle());
            callST.setInt(8, product.getGuarantee());
            callST.setInt(9, product.getOneSwitchOne());
            callST.setString(10, product.getDescription());
            callST.setBoolean(11, product.isStatus());
            callST.setString(12, product.getCatalogId());
            callST.registerOutParameter(13, Types.BOOLEAN);
            callST.execute();
            check = callST.getBoolean(13);
            if(check) {
                handleProductSpecification(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
    
    public boolean updateProduct(Product product) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call updateProduct(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            callST.setString(1, product.getProductId());
            callST.setString(2, product.getProductName());
            callST.setFloat(3, product.getPriceOutput());
            callST.setInt(4, product.getDiscount());
            callST.setInt(5, product.getQuantity());
            callST.setInt(6, product.getQuality());
            callST.setString(7, product.getTitle());
            callST.setInt(8, product.getGuarantee());
            callST.setInt(9, product.getOneSwitchOne());
            callST.setString(10, product.getDescription());
            callST.setBoolean(11, product.isStatus());
            callST.setString(12, product.getCatalogId());
            callST.registerOutParameter(13, Types.BOOLEAN);
            callST.execute();
            check = callST.getBoolean(13);
            if(check) {
                handleProductSpecification(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
    
    public boolean deleteProduct(String productId) {
        Connection con = null;
        CallableStatement callST = null;
        boolean result = false;
        
        deleteSpecificationByProductId(productId);
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call deleteProduct(?,?)}");
            callST.setString(1, productId);
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
    
    public boolean toggleProduct(String productId) {
        Connection con = null;
        CallableStatement callST = null;
        boolean result = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call toggleProduct(?,?)}");
            callST.setString(1, productId);
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
    
    //****************************Specification****************************//
    public boolean insertSpecification(Specification specification) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call insertSpecification(?,?,?,?,?)}");
            callST.setString(1, specification.getSpecificationKey());
            callST.setString(2, specification.getSpecification());
            callST.setBoolean(3, true);
            callST.setString(4, specification.getProductId());
            callST.registerOutParameter(5, Types.BOOLEAN);
            callST.execute();
            check = callST.getBoolean(5);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
    
    public boolean updateSpecification(Specification specification) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call updateSpecification(?,?,?,?,?)}");
            callST.setString(1, specification.getSpecificationKey());
            callST.setString(2, specification.getSpecification());
            callST.setBoolean(3, specification.isStatus());
            callST.setString(4, specification.getProductId());
            callST.registerOutParameter(5, Types.BOOLEAN);
            callST.execute();
            check = callST.getBoolean(5);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
    
    public void deleteSpecificationByProductId(String productId) {
        Connection con = null;
        CallableStatement callST = null;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call deleteSpecificationByProductId(?)}");
            callST.setString(1, productId);
            callST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
    }
    
    public Specification selectSpecificationByKey(String key,boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        Specification spec = new Specification();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call selectSpecificationByKey(?,?)}");
            callST.setString(1, key);
            callST.setBoolean(2, isAdmin);
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                spec.setSpecificationId(rs.getInt("SpecificationId"));
                spec.setSpecificationKey(rs.getString("SpecificationKey"));
                spec.setSpecification(rs.getString("Specification"));
                spec.setStatus(rs.getBoolean("Status"));
                spec.setProductId(rs.getString("ProductId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return spec;
    }
    
    public List<Specification> selectSpecificationByProductId(String productId,boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Specification> listSpec = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call selectSpecificationByProductId(?,?)}");
            callST.setString(1, productId);
            callST.setBoolean(2, isAdmin);
            ResultSet rs = callST.executeQuery();
            while(rs.next()) {
                Specification spec = new Specification();
                spec.setSpecificationId(rs.getInt("SpecificationId"));
                spec.setSpecificationKey(rs.getString("SpecificationKey"));
                spec.setSpecification(rs.getString("Specification"));
                spec.setStatus(rs.getBoolean("Status"));
                spec.setProductId(rs.getString("ProductId"));
                listSpec.add(spec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return listSpec;
    }
    
    public boolean checkSpecificationExist(String specKey, String productId) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call checkSpecificationExist(?,?,?)}");
            callST.setString(1, specKey);
            callST.setString(2, productId);
            callST.registerOutParameter(3, Types.BOOLEAN);
            callST.execute();
            check = callST.getBoolean(3);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
    
    public void handleSpecification(Specification specification) {
        if(checkSpecificationExist(specification.getSpecificationKey(), specification.getProductId())) {
            updateSpecification(specification);
        }else {
            insertSpecification(specification);
        }
    }
    
    public void handleProductSpecification(Product product) {
        product.bindAllSpecification();
        product.activeAllSpecification();
        List<Specification> specification = product.getSpecification();
        for (Specification spec : specification) {
            handleSpecification(spec);
        }
    }
}