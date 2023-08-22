package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.CartsDAO;
import com.example.myapplication.dao.OrdersDAO;
import com.example.myapplication.dao.ProductsDAO;
import com.example.myapplication.dao.RatingsDAO;
import com.example.myapplication.dao.UsersDAO;
import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.User;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    EditText edtUserName, edtPassword, edtFirstName, edtLastName, edtPhoneNumber, edtAddress, edtEmail, edtTempPassword;
    Button btnCreate;
    UsersDAO usersDAO;
    CartsDAO cartsDAO;
    OrdersDAO ordersDAO;
    ProductsDAO productsDAO;
    RatingsDAO ratingsDAO;
    SqlHandle sqlHandle;
    ListView lstData;
    ArrayList<User> listUser;
    ArrayList<String> print;
    ArrayAdapter<String> adapter;
    User infoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        init();
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                String firstName = edtFirstName.getText().toString();
                String lastName = edtLastName.getText().toString();
                String phoneNumber = edtPhoneNumber.getText().toString();
                String address = edtAddress.getText().toString();
                String email = edtEmail.getText().toString();
                String tempPassword = edtTempPassword.getText().toString();


                if (usersDAO.isEmpty(userName) || usersDAO.isEmpty(password) || usersDAO.isEmpty(firstName) || usersDAO.isEmpty(lastName) || usersDAO.isEmpty(phoneNumber) || usersDAO.isEmpty(address) || usersDAO.isEmpty(email) || usersDAO.isEmpty(tempPassword))
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                else {
                    if (usersDAO.checkDuplicateAccount(userName)) {
                        Toast.makeText(RegisterActivity.this, "Trùng username", Toast.LENGTH_SHORT).show();
                    } else {
                        if (password.equals(tempPassword)){
                            infoUser = new User(userName, password, firstName, lastName, phoneNumber, address, email, "user");
                            String checkInsert = usersDAO.userInsert(userName, password, firstName, lastName, phoneNumber, address, email, "user");
                            Toast.makeText(RegisterActivity.this, checkInsert, Toast.LENGTH_SHORT).show();
                            if (usersDAO.signIn(infoUser)) {
                                Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, MenuActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "Đăng ký không thành công!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "Mật khẩu không trùng khớp!",Toast.LENGTH_SHORT).show();
                        }
                    }

                }

            }
        });
    }
    private void init() {
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTempPassword = (EditText) findViewById(R.id.edtTempPassword);

        sqlHandle = new SqlHandle(this);
        usersDAO = new UsersDAO(this);
        infoUser = new User(-1, null, null, null, null, null, null, null, null);
        btnCreate = (Button) findViewById(R.id.btnCreate);
    }
}