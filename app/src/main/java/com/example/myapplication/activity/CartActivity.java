package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.CartAdapter;
import com.example.myapplication.dao.CartsDAO;
import com.example.myapplication.dao.ProductsDAO;
import com.example.myapplication.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ImageButton btnBack;
    RecyclerView rcvProduct;
    CartsDAO cartsDAO;
    CartAdapter cartAdapter;
    ArrayList<Cart> cartItems;
    ListView listViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ArrayList<Cart> cartItems;
        listViewCart = findViewById(R.id.ListViewCart);
        cartsDAO = new CartsDAO(CartActivity.this);
        cartItems = cartsDAO.cartsRead();

        ArrayList<String> cartItemStrings = new ArrayList<>();
        for (Cart cartItem : cartItems) {
            cartItemStrings.add("Product: " + cartItem.getProductName() + ", Quantity: " + cartItem.getQuantity()
                                + ", Price" + cartItem.getPrice());
        }

        ArrayAdapter<String> cartAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItemStrings);
        listViewCart.setAdapter(cartAdapter);
    }
}