package com.example.myapplication.model;

public class Product {
    private int ProductId;
    private String ProductName;
    private int Price;
    private String Description;
    private int CategoryId;

    public Product(int productId, String productName, int price, String description, int categoryId) {
        ProductId = productId;
        ProductName = productName;
        Price = price;
        Description = description;
        CategoryId = categoryId;
    }

    public Product(String productName, String description) {
        ProductName = productName;
        Description = description;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
}
