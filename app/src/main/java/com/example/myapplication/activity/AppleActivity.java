package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.CartsDAO;
import com.example.myapplication.dao.OrdersDAO;
import com.example.myapplication.database.SqlHandle;

public class AppleActivity extends AppCompatActivity {

    ImageButton btnBackApple;
    Button btnAppleAdd;
    SqlHandle sqlHandle;
    CartsDAO cartsDAO;
    TextView priceApple;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);

        btnBackApple = (ImageButton) findViewById(R.id.btnBackApple);
        btnBackApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppleActivity.this, CategoryActivity.class));
            }
        });
        btnAppleAdd = (Button) findViewById(R.id.btnAppleAdd);
        btnAppleAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AppleActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                CartsDAO cartsDAO = new CartsDAO(AppleActivity.this);
                int userId = 11; // Thay đổi userId tương ứng
                int productId = 1; // Thay đổi productId tương ứng
                String size = "kg"; // Thay đổi size tương ứng
                int quantity = 1;
                int price = (int) cartsDAO.getProductPrice(productId);// Thay đổi quantity tương ứng
                String result = cartsDAO.cartsInsert(userId, productId, size, quantity, price);
                Toast.makeText(AppleActivity.this, result, Toast.LENGTH_SHORT).show();

            }
        });
    }
}