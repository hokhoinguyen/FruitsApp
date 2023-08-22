package com.example.myapplication.model;

public class Rating {
    private int RatingId;
    private double Rating;
    private String Comment;
    private int UserId;
    private int CategoryId;

    public Rating(int ratingId, double rating, String comment, int userId, int categoryId) {
        RatingId = ratingId;
        Rating = rating;
        Comment = comment;
        UserId = userId;
        CategoryId = categoryId;
    }

    public int getRatingId() {
        return RatingId;
    }

    public void setRatingId(int ratingId) {
        RatingId = ratingId;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
}
