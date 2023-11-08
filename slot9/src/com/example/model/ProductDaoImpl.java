package com.example.model;

import com.example.dao.DBConnection;
import com.example.entity.Products;
import com.mysql.cj.log.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoImpl implements ProductDao{
    private final Connection conn = DBConnection.createConnection();
    private final String SQL_CREATE_PRODUCT = "INSERT INTO Products (productName,productDesc,productPrice) " +
            "VALUES (?,?,?)";
    private final String SQL_GET_PRODUCT_BY_ID = "SELECT * FROM products WHERE Id = ?";
    private final String SQL_GET_ALL_PRODUCT = "SELECT * FROM products";
    private final String SQL_UPDATE_PRODUCT = "UPDATE products SET" +
            " productName = ?,productDesc = ?, productPrice = ?  WHERE Id = ?";
    private final String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE Id = ?";

    @Override
    public void createProduct(Products product) {
        try(PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_PRODUCT,Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1,product.getProductName());
            pstmt.setString(2,product.getProductDesc());
            pstmt.setDouble(3,product.getProductPrice());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if (generatedKeys.next()){
                    product.setProductID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public Products getProductByID(int productId) {
        Products product = new Products();
        try(PreparedStatement pstmt = conn.prepareStatement(SQL_GET_PRODUCT_BY_ID)) {
            pstmt.setInt(1,productId);
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()){
                    product.setProductID(rs.getInt(1));
                    product.setProductName(rs.getString(2));
                    product.setProductDesc(rs.getString(3));
                    product.setProductPrice(rs.getDouble(4));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return product;
    }

    @Override
    public ArrayList<Products> getAllProducts() {
        ArrayList<Products> allProducts = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_PRODUCT);
        ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                Products product = new Products();
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setProductDesc(rs.getString(3));
                product.setProductPrice(rs.getDouble(4));
                allProducts.add(product);
            }
        }catch (SQLException ex){
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return allProducts;
    }

    @Override
    public void updateProduct(Products product) {
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_PRODUCT)){
            pstmt.setString(1,product.getProductName());
            pstmt.setString(2,product.getProductDesc());
            pstmt.setDouble(3,product.getProductPrice());
            pstmt.setInt(8,product.getProductID());
            pstmt.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public boolean deleteProduct(int productId) {
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_PRODUCT)){
            pstmt.setInt(1,productId);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
}

