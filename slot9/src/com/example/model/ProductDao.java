package com.example.model;

import com.example.entity.Products;

import java.util.ArrayList;

public interface ProductDao {
    public void createProduct(Products product);
    public Products getProductByID(int productId);
    public ArrayList<Products> getAllProducts();
    public void updateProduct(Products product);
    public boolean deleteProduct(int productId);
}
