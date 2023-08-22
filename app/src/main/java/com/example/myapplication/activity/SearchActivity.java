package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.dao.ProductsDAO;
import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView rcvProduct;
    ProductAdapter productAdapter;
    ProductsDAO productsDAO;
    Product product;
    SqlHandle sqlHandle;
    SQLiteDatabase prodDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        rcvProduct = (RecyclerView) findViewById(R.id.rcvProduct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvProduct.setLayoutManager(linearLayoutManager);
        sqlHandle = new SqlHandle(this);
        prodDb = sqlHandle.getDatabase();
        productsDAO = new ProductsDAO(prodDb);

        productAdapter = new ProductAdapter(getListProducts());
        rcvProduct.setAdapter(productAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);
    }

    private List<Product> getListProducts() {
        List<Product> list = new ArrayList<>();
//        productsDAO.prodInsert();
        ArrayList<Product> prodList = productsDAO.prodRead1();
//        String productName = product.getProductName();
//        String description = product.getDescription();
//        list.add(new Product(productName, description));

        for (Product product : prodList) {
            String productName = product.getProductName();
            String description = product.getDescription();
            list.add(new Product(productName, description));
        }
        return list;
    }
}