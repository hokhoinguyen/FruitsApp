package com.example.myapplication.model;

public class Cart {
    private int CartId;
    private int UserId;
    private int ProductId;
    private String Size;
    private int Quantity;
    private int Price;
    private String ProductName;

    public Cart(int cartId, int userId, int productId, String size, int quantity, int price) {
        CartId = cartId;
        UserId = userId;
        ProductId = productId;
        Size = size;
        Quantity = quantity;
        Price = price;
    }


    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getProductName() {
        return ProductName;
    }
}
