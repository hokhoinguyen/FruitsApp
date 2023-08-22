package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MenuAdminActivity extends AppCompatActivity {
    Button btnUsers, btnProducts, btnOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        init();
        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAdminActivity.this, UserAdActivity.class));
            }
        });
    }

    private void init() {
        btnUsers = (Button) findViewById(R.id.btnUsers);
        btnProducts = (Button) findViewById(R.id.btnProducts);
        btnOrders = (Button) findViewById(R.id.btnOrders);
    }
}