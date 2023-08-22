package com.example.myapplication.database;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.User;

import java.util.ArrayList;

public class SqlHandle {
    SQLiteDatabase mydatabase;

    public SqlHandle(Context context) {
        mydatabase = context.openOrCreateDatabase("fruits.db",MODE_PRIVATE,null);

        try {
            String sql = "CREATE TABLE Users(UserId integer primary key autoincrement, UserName text, Password text, FirstName text, LastName text, " +
                    "PhoneNumber text, Address text, Email text, Role text)";
            mydatabase.execSQL(sql);

            String sql1 = "Create Table Products(ProductId integer primary key autoincrement,"
                    + "ProductName text, Price integer, Description text)";
            mydatabase.execSQL(sql1);
//            mydatabase.execSQL("Insert Into Products Values(null, 'Apple', 300000, 'Description A')");
//            mydatabase.execSQL("Insert Into Products Values(null, 'Coconut', 200000, 'Description B')");
//            mydatabase.execSQL("Insert Into Products Values(null, 'Avocado', 500000, 'Description C')");
//            mydatabase.execSQL("Insert Into Products Values(null, 'Orange', 500000, 'Description D')");
//            mydatabase.execSQL("Insert Into Products Values(null, 'Pear', 500000, 'Description E')");
//            mydatabase.execSQL("Insert Into Products Values(null, 'Pineapple', 500000, 'Description F')");

            String sql2 = "Create Table Ratings(RatingId integer primary key autoincrement,"
                    + "Rating double, Comment text, UserId integer," +
                    "Foreign Key (UserId) References Orders(UserId))";
            mydatabase.execSQL(sql2);
//            mydatabase.execSQL("Insert Into Ratings Values(null, 3, 'Okay product', null)");
//            mydatabase.execSQL("Insert Into Ratings Values(null, 4, 'Very good!', null)");
//            mydatabase.execSQL("Insert Into Ratings Values(null, 3, 'Excellent!', null)");

            String sql3 = "Create Table Orders(OrderId integer primary key autoincrement,"
                    + "Size text, Quantity integer, OrderDate text, OrderStatus text," +
                    "UserId integer, ProductName text," +
                    "Foreign Key (UserId) References Users(UserId), Foreign Key (ProductName) References Products(ProductName))";
            mydatabase.execSQL(sql3);
//            mydatabase.execSQL("Insert Into Orders Values(null, 'kg', 2, '2023-07-30', 'Processing', null)");
//            mydatabase.execSQL("Insert Into Orders Values(null, 'kg', 1, '2023-07-29', 'Completed', null)");
//            mydatabase.execSQL("Insert Into Orders Values(null, 'kg', 3, '2023-07-28', 'Processing', null)");

            String sql4 = "Create Table Carts(CartId integer primary key autoincrement," +
                    "UserId integer, Size text, Quantity integer, Price integer, " +
                    "Foreign Key (UserId) References Orders(UserId), " +
                    "Foreign Key (Size) References Orders(Size)," +
                    "Foreign Key (Quantity) References Orders(Quantity)," +
                    "Foreign Key (Price) References Products(Price))";
            mydatabase.execSQL(sql4);
//            mydatabase.execSQL("Insert Into Carts Values(null, null, null, 'kg', 2)");
//            mydatabase.execSQL("Insert Into Carts Values(null, null, null, 'kg', 1)");
//            mydatabase.execSQL("Insert Into Carts Values(null, null, null, 'kg', 3)");
        }
        catch (Exception e)
        {

        }
    }

    public SQLiteDatabase getDatabase() {
        return mydatabase;
    }

    public void Drop(String tableName) {
        String sql = "Drop Table If Exists " + tableName;
        mydatabase.execSQL(sql);
    }

}
