package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class CategoryActivity extends AppCompatActivity {
    ImageButton btnBackCat, btnAdd1, btnAdd2, btnAdd3, btnAdd4, btnAdd5, btnAdd6;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        init();
        btnBackCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, OrangeActivity.class));
            }
        });

        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, AppleActivity.class));
            }
        });

        btnAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, CoconutActivity.class));
            }
        });

        btnAdd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, PineappleActivity.class));
            }
        });

        btnAdd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, PearActivity.class));
            }
        });

        btnAdd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, AvocadoActivity.class));
            }
        });
    }

    private void init() {
        btnBackCat = (ImageButton) findViewById(R.id.btnBackCat);
        btnAdd1 = (ImageButton) findViewById(R.id.btnAdd1);
        btnAdd2 = (ImageButton) findViewById(R.id.btnAdd2);
        btnAdd3 = (ImageButton) findViewById(R.id.btnAdd3);
        btnAdd4 = (ImageButton) findViewById(R.id.btnAdd4);
        btnAdd5 = (ImageButton) findViewById(R.id.btnAdd5);
        btnAdd6 = (ImageButton) findViewById(R.id.btnAdd6);
    }
}