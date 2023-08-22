package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.User;

import java.util.ArrayList;

public class UsersDAO {

    SQLiteDatabase userDatabase;

    public UsersDAO(Context context) {
        userDatabase = new SqlHandle(context).getDatabase();
    }

    public String userInsert(String userName, String password, String firstName, String lastName, String phoneNumber, String address, String email, String role) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("UserName", userName);
        myvalue.put("Password", password);
        myvalue.put("FirstName", firstName);
        myvalue.put("LastName", lastName);
        myvalue.put("PhoneNumber", phoneNumber);
        myvalue.put("Address", address);
        myvalue.put("Email", email);
        myvalue.put("Role", role);
        String msg = "";
        if (userDatabase.insert("Users",null, myvalue) == -1)
        {
            msg = "Fail to Insert Record!";
        }
        else {
            msg ="Insert record Sucessfully";
        }
        return msg;
    }



    public String userDelete(Integer userId) {
        int n = userDatabase.delete("Users","UserId = ?", new
                String[]{userId.toString()});
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

    public String userUpdate(Integer userId, String userName, String password, String firstName, String lastName, String phoneNumber, String address, String email, String role) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("UserName", userName);
        myvalue.put("Password", password);
        myvalue.put("FirstName", firstName);
        myvalue.put("LastName", lastName);
        myvalue.put("PhoneNumber", phoneNumber);
        myvalue.put("Address", address);
        myvalue.put("Email", email);
        myvalue.put("Role", role);
        int n = userDatabase.update("Users", myvalue,"UserId = ?", new
                String[]{userId.toString()});
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

    public String userUpdate1(Integer userId, String userName, String firstName, String lastName, String phoneNumber, String address, String email, String role) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("UserName", userName);
        myvalue.put("FirstName", firstName);
        myvalue.put("LastName", lastName);
        myvalue.put("PhoneNumber", phoneNumber);
        myvalue.put("Address", address);
        myvalue.put("Email", email);
        myvalue.put("Role", role);
        int n = userDatabase.update("Users", myvalue,"UserId = ?", new
                String[]{userId.toString()});
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

    public ArrayList<User> userRead() {
        ArrayList<User> listUser = new ArrayList<>();
        Integer userId = 0;
        String userName = "";
        String password = "";
        String firstName = "";
        String lastName = "";
        String phoneNumber = "";
        String address = "";
        String email = "";
        String role = "";
        Cursor c = userDatabase.query("Users",null,null,null,null,null,null);
        c.moveToNext();
        String data = "";
        while (c.isAfterLast() == false)
        {
            userId = c.getInt(0);
            userName = c.getString(1);
            password = c.getString(2);
            firstName = c.getString(3);
            lastName = c.getString(4);
            phoneNumber = c.getString(5);
            address = c.getString(6);
            email = c.getString(7);
            role = c.getString(8);
            c.moveToNext();
            listUser.add(new User(userId, userName, password, firstName, lastName, phoneNumber, address, email, role));
        }
        c.close();
        return listUser;
    }

    public boolean signIn(User user) {
//        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UserName", user.getUserName());
        values.put("Password", user.getPassword());
        values.put("Role", user.getRole());

        long row = userDatabase.insert("Users", null, values);
        return (row > 0);
    }

    public boolean checkRole(String userName) {
        String sql = "SELECT * FROM Users WHERE UserName=? AND Role='admin'";
        Cursor c = userDatabase.rawQuery(sql, new String[] {userName});
        int count = c.getCount();
        c.close();
        return (count > 0);
    }

    public boolean checkLogin(String userName, String password) {
        String sql = "Select * From Users Where UserName=? And Password=?";
        Cursor c = userDatabase.rawQuery(sql, new String[] {userName, password});
        int count = c.getCount();
        c.close();
        return (count > 0);
    }

    public boolean checkDuplicateAccount(String userName) {
        String sql = "Select UserName From Users Where UserName=?";
        Cursor c = userDatabase.rawQuery(sql, new String[] {userName});
        int count = c.getCount();
        c.close();
        return (count > 0);
    }

    public boolean isEmpty(String str) {
        return str.isEmpty();
    }
}
