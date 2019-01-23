/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.entity.Account;
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
public class AccountModel {
    public boolean createAccount(Account account) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call createAccount(?,?,?,?,?,?,?,?,?,?,?,?)}");
            callST.setString(1, account.getAccountId());
            callST.setString(2, account.getUserName());
            callST.setString(3, account.getPassWord());
            callST.setInt(4, account.getType());
            callST.setString(5, account.getAvatar());
            callST.setString(6, account.getFullName());
            callST.setDate(7, account.getBirthDay());
            callST.setString(8, account.getMail());
            callST.setString(9, account.getPhone());
            callST.setString(10, account.getAdress());
            callST.setBoolean(11, account.isStatus());
            callST.registerOutParameter(12, Types.BOOLEAN);
            callST.execute();
            check = callST.getBoolean(12);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return check;
    }
    
    public Account selectAccountById(String accountId ,boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        Account account = null;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call selectAccountById(?,?)}");
            callST.setString(1, accountId);
            callST.setBoolean(2, isAdmin);
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                account = new Account();
                account.setAccountId(rs.getString("AccountId"));
                account.setUserName(rs.getString("UserName"));
                account.setType(rs.getInt("Type"));
                account.setAvatar(rs.getString("Avatar"));
                account.setFullName(rs.getString("FullName"));
                account.setBirthDay(rs.getDate("BirthDay"));
                account.setMail(rs.getString("Mail"));
                account.setPhone(rs.getString("Phone"));
                account.setAdress(rs.getString("Adress"));
                account.setIsOnline(rs.getBoolean("IsOnline"));
                account.setStatus(rs.getBoolean("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return account;
    }
    
    public Account selectAccountByUsername(String userName ,boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        Account account = null;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call selectAccountByUsername(?,?)}");
            callST.setString(1, userName);
            callST.setBoolean(2, isAdmin);
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                account = new Account();
                account.setAccountId(rs.getString("AccountId"));
                account.setUserName(rs.getString("UserName"));
                account.setType(rs.getInt("Type"));
                account.setAvatar(rs.getString("Avatar"));
                account.setFullName(rs.getString("FullName"));
                account.setBirthDay(rs.getDate("BirthDay"));
                account.setMail(rs.getString("Mail"));
                account.setPhone(rs.getString("Phone"));
                account.setAdress(rs.getString("Adress"));
                account.setIsOnline(rs.getBoolean("IsOnline"));
                account.setStatus(rs.getBoolean("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return account;
    }
    
    public List<Account> selectUserAccount(boolean isAdmin) {
        Connection con = null;
        CallableStatement callST = null;
        List<Account> listAccount = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call selectUserAccount(?,?)}");
            callST.setBoolean(1, isAdmin);
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getString("AccountId"));
                account.setUserName(rs.getString("UserName"));
                account.setType(rs.getInt("Type"));
                account.setAvatar(rs.getString("Avatar"));
                account.setFullName(rs.getString("FullName"));
                account.setBirthDay(rs.getDate("BirthDay"));
                account.setMail(rs.getString("Mail"));
                account.setPhone(rs.getString("Phone"));
                account.setAdress(rs.getString("Adress"));
                account.setIsOnline(rs.getBoolean("IsOnline"));
                account.setStatus(rs.getBoolean("Status"));
                listAccount.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return listAccount;
    }
    
    public List<Account> selectModeratorAccount() {
        Connection con = null;
        CallableStatement callST = null;
        List<Account> listAccount = new ArrayList<>();
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call selectModeratorAccount()}");
            ResultSet rs = callST.executeQuery();
            if(rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getString("AccountId"));
                account.setUserName(rs.getString("UserName"));
                account.setType(rs.getInt("Type"));
                account.setAvatar(rs.getString("Avatar"));
                account.setFullName(rs.getString("FullName"));
                account.setBirthDay(rs.getDate("BirthDay"));
                account.setMail(rs.getString("Mail"));
                account.setPhone(rs.getString("Phone"));
                account.setAdress(rs.getString("Adress"));
                account.setIsOnline(rs.getBoolean("IsOnline"));
                account.setStatus(rs.getBoolean("Status"));
                listAccount.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callST);
        }
        return listAccount;
    }
    
    public boolean loginModerator(String userName, String passWord) {
        Connection con = null;
        CallableStatement callST = null;
        boolean check = false;
        try {
            con = ConnectionDB.openConnection();
            callST = con.prepareCall("{call loginModerator()}");
            callST.setString(1, userName);
            callST.setString(2, passWord);
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
}
