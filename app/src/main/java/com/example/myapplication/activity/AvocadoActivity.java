package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.CartsDAO;
import com.example.myapplication.database.SqlHandle;

public class AvocadoActivity extends AppCompatActivity {
    ImageButton btnBackAvocado;
    SqlHandle sqlHandle;
   Button btnAvocado;
    CartsDAO cartsDAO;
    TextView priceAvocado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avocado);
        btnBackAvocado = (ImageButton) findViewById(R.id.btnBackAvocado);
        btnBackAvocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AvocadoActivity.this, CategoryActivity.class));
            }
        });
        btnAvocado = (Button) findViewById(R.id.btnAvocado);
        btnAvocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AvocadoActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                int userId = 11; // Thay đổi userId tương ứng
                int productId = 1; // Thay đổi productId tương ứng
                String size = "kg"; // Thay đổi size tương ứng
                int quantity = 1;
                int price = (int) cartsDAO.getProductPrice(productId);// Thay đổi quantity tương ứng

                CartsDAO cartsDAO = new CartsDAO(AvocadoActivity.this);
                String result = cartsDAO.cartsInsert(userId, productId, size, quantity, price);

                Toast.makeText(AvocadoActivity.this, result, Toast.LENGTH_SHORT).show();

                priceAvocado = (TextView) findViewById(R.id.priceAvocado);
                priceAvocado.setText("Price: " + price + " VND");
            }
        });
    }
}