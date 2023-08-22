package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.Rating;

import java.util.ArrayList;

public class RatingsDAO {
    SQLiteDatabase ratingDatabase;

    public RatingsDAO(Context context) {
        ratingDatabase = new SqlHandle(context).getDatabase();
    }

    public String ratingInsert(Integer ratingId, double rating, String comment, Integer userId, Integer categoryId) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("Rating", rating);
        myvalue.put("Comment", comment);
        myvalue.put("UserId", userId);
        myvalue.put("CategoryId", categoryId);
        String msg = "";
        if (ratingDatabase.insert("Ratings",null, myvalue) == -1)
        {
            msg = "Fail to Insert Record!";
        }
        else {
            msg ="Insert record Sucessfully";
        }
        return msg;
    }
    public String ratingDelete(Integer ratingId) {
        int n = ratingDatabase.delete("Ratings","RatingId = ?", new
                String[]{ratingId.toString()});
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
    public String ratingUpdate(Integer ratingId, double rating, String comment, Integer userId, Integer categoryId) {
        ContentValues myvalue = new ContentValues();
        myvalue.put("Rating", rating);
        myvalue.put("Comment", comment);
        myvalue.put("UserId", userId);
        myvalue.put("CategoryId", categoryId);
        int n = ratingDatabase.update("Ratings", myvalue,"RatingId = ?", new
                String[]{ratingId.toString()});
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
    public ArrayList<Rating> ratingRead() {
        ArrayList<Rating> listRating = new ArrayList<>();
        Integer ratingId = 0;
        double rating = 0;
        String comment = "";
        Integer userId = 0;
        Integer categoryId = 0;
        Cursor c = ratingDatabase.query("Ratings", null, null, null, null, null, null);
        c.moveToNext();
        String data = "";
        while (c.isAfterLast() == false) {
            ratingId = c.getInt(0);
            rating = c.getDouble(1);
            comment = c.getString(2);
            userId = c.getInt(3);
            categoryId = c.getInt(4);
            c.moveToNext();
            listRating.add(new Rating(ratingId, rating, comment, userId, categoryId));
        }
        c.close();
        return listRating;
    }
}
