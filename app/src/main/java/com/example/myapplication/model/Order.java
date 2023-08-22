package com.example.myapplication.model;

import java.util.Date;

public class Order {
    private int OrderId;
    private String Size;
    private int Quantity;
    private String OrderDate;
    private String OrderStatus;
    private int UserId;
    private int ProductId;

    public Order(int orderId, String size, int quantity, String orderDate, String orderStatus, int userId, int productId) {
        OrderId = orderId;
        Size = size;
        Quantity = quantity;
        OrderDate = orderDate;
        OrderStatus = orderStatus;
        UserId = userId;
        ProductId = productId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
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

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
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
}
