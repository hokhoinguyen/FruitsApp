package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.CartsDAO;
import com.example.myapplication.database.SqlHandle;

public class CoconutActivity extends AppCompatActivity {
    ImageButton btnBackCoconut;
    Button btnCoconut;
    SqlHandle sqlHandle;
    CartsDAO cartsDAO;
    TextView priceCoconut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coconut);
        btnBackCoconut = (ImageButton) findViewById(R.id.btnBackCoconut);
        btnBackCoconut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoconutActivity.this, CategoryActivity.class));
            }
        });
        btnCoconut = (Button) findViewById(R.id.btnCoconut);
        btnCoconut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Toast.makeText(CoconutActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                int userId = 11; // Thay đổi userId tương ứng
                int productId = 1; // Thay đổi productId tương ứng
                String size = "kg"; // Thay đổi size tương ứng
                int quantity = 1;
                int price = (int) cartsDAO.getProductPrice(productId);// Thay đổi quantity tương ứng

                CartsDAO cartsDAO = new CartsDAO(CoconutActivity.this);
                String result = cartsDAO.cartsInsert(userId, productId, size, quantity, price);

                Toast.makeText(CoconutActivity.this, result, Toast.LENGTH_SHORT).show();

                priceCoconut = (TextView) findViewById(R.id.priceAvocado);
                priceCoconut.setText("Price: " + price + " VND");
            }
        });
    }
}