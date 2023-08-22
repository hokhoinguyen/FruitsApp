package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.UsersDAO;
import com.example.myapplication.database.SqlHandle;

public class MainActivity extends AppCompatActivity {

    EditText edtSignInUserName, edtSignInPassword;
    Button btnLogin, btnRegister;
    UsersDAO usersDao;
    SqlHandle sqlHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtSignInUserName = (EditText) findViewById(R.id.edtSignInUserName);
                edtSignInPassword = (EditText) findViewById(R.id.edtSignInPassword);
                String userName = edtSignInUserName.getText().toString();
                String password = edtSignInPassword.getText().toString();

                if (usersDao.checkLogin(userName, password)) {
                    if(usersDao.checkRole(userName))
                        startActivity(new Intent(MainActivity.this, MenuAdminActivity.class)); // Admin
                    else
                        startActivity(new Intent(MainActivity.this, MenuActivity.class)); // User
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    private void init() {
        usersDao = new UsersDAO(MainActivity.this);
        sqlHandle = new SqlHandle(this);
        sqlHandle.getDatabase();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }
}