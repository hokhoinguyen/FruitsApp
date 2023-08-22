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

public class PearActivity extends AppCompatActivity {
    ImageButton btnBackPear;
    Button btnPear;
    SqlHandle sqlHandle;
    CartsDAO cartsDAO;
    TextView pricePear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pear);
        btnBackPear = (ImageButton) findViewById(R.id.btnBackPear);
        btnBackPear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PearActivity.this, CategoryActivity.class));
            }
        });
        btnPear = (Button) findViewById(R.id.btnPear);
        btnPear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PearActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                int userId = 11; // Thay đổi userId tương ứng
                int productId = 1; // Thay đổi productId tương ứng
                String size = "kg"; // Thay đổi size tương ứng
                int quantity = 1;
                int price = (int) cartsDAO.getProductPrice(productId);// Thay đổi quantity tương ứng

                CartsDAO cartsDAO = new CartsDAO(PearActivity.this);
                String result = cartsDAO.cartsInsert(userId, productId, size, quantity, price);

                Toast.makeText(PearActivity.this, result, Toast.LENGTH_SHORT).show();

               pricePear= (TextView) findViewById(R.id.priceAvocado);
               pricePear.setText("Price: " + price + " VND");
            }
        });
    }
}