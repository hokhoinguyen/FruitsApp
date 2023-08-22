package com.example.myapplication.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.Cart;

import java.util.ArrayList;

public class CartsDAO {
    SQLiteDatabase cartsDatabase;

    public CartsDAO(Context context) {
        cartsDatabase = new SqlHandle(context).getDatabase();
    }

    public String cartsInsert(Integer userId, Integer productId, String size, Integer quantity, Integer price) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("UserId", userId);
        myvalue.put("ProductId", productId);
        myvalue.put("Size", size);
        myvalue.put("Quantity", quantity);
        myvalue.put("Price", price);
        String msg = "";
//        if (cartsDatabase.insert("Carts",null, myvalue) == -1)
//        {
//            msg = "Fail to Insert Record!";
//        }
//        else {
            msg ="Insert record Sucessfully";
//        }
        return msg;
    }
    public String cartsDelete(Integer cartId) {
        int n = cartsDatabase.delete("Carts","CartId = ?", new
                String[]{cartId.toString()});
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
    public String cartsUpdate(Integer cartId, Integer userId, Integer productId, String size, Integer quantity, Integer price) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("UserId", userId);
        myvalue.put("ProductId", productId);
        myvalue.put("Size", size);
        myvalue.put("Quantity", quantity);
        myvalue.put("Price", price);
        int n = cartsDatabase.update("Carts", myvalue,"CartId = ?", new
                String[]{cartId.toString()});
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
    public ArrayList<Cart> cartsRead() {
        ArrayList<Cart> listCart = new ArrayList<>();
        Integer cartId = 0;
        Integer userId = 0;
        Integer productId = 0;
        String size = "";
        Integer quantity = 0;
        Integer price = 0;
        Cursor c = cartsDatabase.query("Carts", null, null, null, null, null, null);
//        c.moveToNext();
//        String data = "";
//        while (c.isAfterLast() == false)
//        {
//            cartId = c.getInt(0);
//            userId = c.getInt(1);
//            productId = c.getInt(2);
//            size = c.getString(3);
//            quantity = c.getInt(4);
//            c.moveToNext();
//            listCart.add(new Cart(cartId, userId, productId, size, quantity));
//        }
//        c.close();
        if (c.moveToFirst()) { // Kiểm tra xem có dữ liệu trong Cursor hay không
            do {
                cartId = c.getInt(0);
                userId = c.getInt(1);
                productId = c.getInt(2);
                size = c.getString(3);
                quantity = c.getInt(4);
                price = c.getInt(5);
                listCart.add(new Cart(cartId, userId, productId, size, quantity, price));
            } while (c.moveToNext());
        }
        return listCart;
    }

    @SuppressLint("Range")
    public double getProductPrice(int productId) {
        int price = 0;

        Cursor c = cartsDatabase.query(
                "Products",
                new String[] {"Price"},
                "ProductId = ?",
                new String[]{String.valueOf(productId)},
                null, null, null);

        if (c.moveToFirst()) {
            price = c.getInt(c.getColumnIndex("Price"));
        }
        c.close();
        return price;
    }
    public String getProductName(int productId) {
        String productName = "";

        Cursor c = cartsDatabase.query(
                "Products",
                new String[] {"ProductName"},
                "ProductId = ?",
                new String[]{String.valueOf(productId)},
                null, null, null);

        if (c.moveToFirst()) {
            productName = c.getString(0); // Lấy giá trực tiếp tại cột đầu tiên
        }
        c.close();
        return productName;
    }

}
