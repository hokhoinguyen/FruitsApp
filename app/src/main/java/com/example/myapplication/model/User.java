package com.example.myapplication.model;

public class User {
    private Integer UserId;
    private String UserName;
    private String Password;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Address;
    private String Email;
    private String Role;

    public User(Integer userId, String userName, String password, String firstName, String lastName, String phoneNumber, String address, String email, String role) {
        UserId = userId;
        UserName = userName;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Address = address;
        Email = email;
        Role = role;
    }

    public User(String userName, String password, String firstName, String lastName, String phoneNumber, String address, String email, String role) {
        UserName = userName;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Address = address;
        Email = email;
        Role = role;
    }

    public User(String userName, String password, String firstName, String lastName, String phoneNumber, String address, String email) {
        UserName = userName;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Address = address;
        Email = email;
    }

    public User(Integer userId, String userName, String firstName, String lastName, String phoneNumber, String address, String email, String role) {
        UserId = userId;
        UserName = userName;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Address = address;
        Email = email;
        Role = role;
    }



    public User(String userName, String password, String role) {
        this.UserName = userName;
        this.Password = password;
        this.Role = role;
    }


    public User(String userName, String password) {
        this.UserName = userName;
        this.Password = password;
    }


    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
