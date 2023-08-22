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

public class OrangeActivity extends AppCompatActivity {
    ImageButton btnBackOrange;
    Button btnOrange;
    SqlHandle sqlHandle;
    CartsDAO cartsDAO;
    TextView priceOrange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange);
        btnBackOrange = (ImageButton) findViewById(R.id.btnBackOrange);
        btnBackOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrangeActivity.this, CategoryActivity.class));
            }
        });
        btnOrange = (Button) findViewById(R.id.btnOrange);
       btnOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OrangeActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                int userId = 11; // Thay đổi userId tương ứng
                int productId = 1; // Thay đổi productId tương ứng
                String size = "kg"; // Thay đổi size tương ứng
                int quantity = 1;
                int price = (int) cartsDAO.getProductPrice(productId);// Thay đổi quantity tương ứng

                CartsDAO cartsDAO = new CartsDAO(OrangeActivity.this);
                String result = cartsDAO.cartsInsert(userId, productId, size, quantity, price);

                Toast.makeText(OrangeActivity.this, result, Toast.LENGTH_SHORT).show();

              priceOrange= (TextView) findViewById(R.id.priceAvocado);
                priceOrange.setText("Price: " + price + " VND");
            }
        });
    }
}