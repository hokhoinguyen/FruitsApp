package com.example.myapplication.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.Cart;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class ProductsDAO {
    SQLiteDatabase prodDatabase;
    SqlHandle sqlHandle;

    public ProductsDAO(Context context) {
        prodDatabase = new SqlHandle(context).getDatabase();
    }

    public ProductsDAO(SQLiteDatabase database) {
        prodDatabase = database;
    }

    public void prodInsert() {
        ContentValues myvalue1 = new ContentValues();
        myvalue1.put("ProductName", "Apple");
        myvalue1.put("Price", 500000);
        myvalue1.put("Description", "Description A");
        prodDatabase.insert("Products", null, myvalue1);

        ContentValues myvalue2 = new ContentValues();
        myvalue2.put("ProductName", "Coconut");
        myvalue2.put("Price", 500000);
        myvalue2.put("Description", "Description B");
        prodDatabase.insert("Products", null, myvalue2);

        ContentValues myvalue3 = new ContentValues();
        myvalue3.put("ProductName", "Avocado");
        myvalue3.put("Price", 500000);
        myvalue3.put("Description", "Description C");
        prodDatabase.insert("Products", null, myvalue3);

        ContentValues myvalue4 = new ContentValues();
        myvalue4.put("ProductName", "Orange");
        myvalue4.put("Price", 500000);
        myvalue4.put("Description", "Description D");
        prodDatabase.insert("Products", null, myvalue4);

        ContentValues myvalue5 = new ContentValues();
        myvalue5.put("ProductName", "Pear");
        myvalue5.put("Price", 500000);
        myvalue5.put("Description", "Description E");
        prodDatabase.insert("Products", null, myvalue5);

        ContentValues myvalue6 = new ContentValues();
        myvalue6.put("ProductName", "Pineapple");
        myvalue6.put("Price", 500000);
        myvalue6.put("Description", "Description F");
        prodDatabase.insert("Products", null, myvalue6);
    }
    public String prodDelete(Integer productId) {
        int n = prodDatabase.delete("Products","ProductId = ?", new
                String[]{productId.toString()});
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
    public String prodUpdate(Integer productId, String productName, Integer price, String description, Integer categoryId) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("ProductName", productName);
        myvalue.put("Price", price);
        myvalue.put("Description", description);
        myvalue.put("CategoryId", categoryId);
        int n = prodDatabase.update("Products", myvalue,"ProductId = ?", new
                String[]{productId.toString()});
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
    public ArrayList<Product> prodRead() {
        ArrayList<Product> listProduct = new ArrayList<>();
        Integer productId = 0;
        String productName = "";
        Integer price = 0;
        String description = "";
        Integer categoryId = 0;
        Cursor c = prodDatabase.query("Products", null, null, null, null, null, null);
        c.moveToNext();
        String data = "";
        while (c.isAfterLast() == false) {
            productId = c.getInt(0);
            productName = c.getString(1);
            price = c.getInt(2);
            description = c.getString(3);
            categoryId = c.getInt(4);
            c.moveToNext();
            listProduct.add(new Product(productId, productName, price, description, categoryId));
        }
        c.close();
        return listProduct;
    }

    @SuppressLint("Range")
    public ArrayList<Product> prodRead1() {
        ArrayList<Product> listProduct = new ArrayList<>();
        Integer productId = 0;
        String productName = "";
        String description = "";
        Cursor c = prodDatabase.query("Products", null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            productId = c.getInt(c.getColumnIndex("ProductId"));
            productName = c.getString(c.getColumnIndex("ProductName"));
            description = c.getString(c.getColumnIndex("Description"));
            listProduct.add(new Product(productName, description));
            c.moveToNext();
        }
        c.close();
        return listProduct;
    }
}
