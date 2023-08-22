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

public class PineappleActivity extends AppCompatActivity {
    ImageButton btnBackPineapple;
    Button btnPineapple;
    SqlHandle sqlHandle;
    CartsDAO cartsDAO;
    TextView pricePineapple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pineapple);
        btnBackPineapple = (ImageButton) findViewById(R.id.btnBackPineapple);
        btnBackPineapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PineappleActivity.this, CategoryActivity.class));
            }
        });
        btnPineapple = (Button) findViewById(R.id.btnPineapple);
        btnPineapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PineappleActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                int userId = 11; // Thay đổi userId tương ứng
                int productId = 1; // Thay đổi productId tương ứng
                String size = "kg"; // Thay đổi size tương ứng
                int quantity = 1;
                int price = (int) cartsDAO.getProductPrice(productId);// Thay đổi quantity tương ứng

                CartsDAO cartsDAO = new CartsDAO(PineappleActivity.this);
                String result = cartsDAO.cartsInsert(userId, productId, size, quantity, price);

                Toast.makeText(PineappleActivity.this, result, Toast.LENGTH_SHORT).show();

                pricePineapple= (TextView) findViewById(R.id.priceAvocado);
                pricePineapple.setText("Price: " + price + " VND");
            }
        });
    }
}