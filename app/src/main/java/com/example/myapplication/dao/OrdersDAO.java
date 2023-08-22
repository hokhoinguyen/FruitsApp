package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.Order;
import com.example.myapplication.model.Product;

import java.sql.Date;
import java.util.ArrayList;

public class OrdersDAO {
    SQLiteDatabase orderDatabase;

    public OrdersDAO(Context context) {
        orderDatabase = new SqlHandle(context).getDatabase();
    }

    public String orderInsert(Integer orderId, String size, Integer quantity, String orderDate, String orderStatus, Integer userId, Integer productId) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("Size", size);
        myvalue.put("Quantity", quantity);
        myvalue.put("OrderDate", orderDate);
        myvalue.put("OrderStatus", orderStatus);
        myvalue.put("UserId", userId);
        myvalue.put("ProductId", productId);
        String msg = "";
        if (orderDatabase.insert("Orders",null, myvalue) == -1)
        {
            msg = "Fail to Insert Record!";
        }
        else {
            msg ="Insert record Sucessfully";
        }
        return msg;
    }
    public String orderDelete(Integer orderId) {
        int n = orderDatabase.delete("Orders","OrderId = ?", new
                String[]{orderId.toString()});
        String msg ="";
        if (n == 0)
        {
            msg = "No record to Delete";
        }
        else {
            msg = n +" record is deleted";
        }
        return msg;
    }
    public String orderUpdate(Integer orderId, String size, Integer quantity, String orderDate, String orderStatus, Integer userId, Integer productId) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("Size", size);
        myvalue.put("Quantity", quantity);
        myvalue.put("OrderDate", orderDate);
        myvalue.put("OrderStatus", orderStatus);
        myvalue.put("UserId", userId);
        myvalue.put("ProductId", productId);
        int n = orderDatabase.update("Orders", myvalue,"OrderId = ?", new
                String[]{orderId.toString()});
        String msg = "";
        if (n == 0)
        {
            msg = "No record to Update";
        }
        else {
            msg = n+ " record is updated";
        }
        return msg;
    }
    public ArrayList<Order> orderRead() {
        ArrayList<Order> listOrder = new ArrayList<>();
        Integer orderId = 0;
        String size = "";
        Integer quantity = 0;
        String orderDate = "";
        String orderStatus = "";
        Integer userId = 0;
        Integer productId = 0;
        Cursor c = orderDatabase.query("Orders", null, null, null, null, null, null);
        c.moveToNext();
        String data = "";
        while (c.isAfterLast() == false) {
            orderId = c.getInt(0);
            size = c.getString(1);
            quantity = c.getInt(2);
            orderDate = c.getString(3);
            orderStatus = c.getString(4);
            productId = c.getInt(5);
            c.moveToNext();
            listOrder.add(new Order(orderId, size, quantity, orderDate, orderStatus, userId, productId));
        }
        c.close();
        return listOrder;
    }
}
