package com.example.f21g4_minions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {



    Product product1 = new Product(R.drawable.gorilla,"Product1","ProductCategory1","ProductDescription1","ProductPrice1");
    Product product2 = new Product(R.drawable.panda,"Product2","ProductCategory2","ProductDescription2","ProductPrice2");
    Product product3 = new Product(R.drawable.bunnysplash,"Product3","ProductCategory3","ProductDescription3","ProductPrice3");
    Product product4 = new Product(R.drawable.eagle,"Product4","ProductCategory4","ProductDescription4","ProductPrice4");

    List<Product> Products = new ArrayList<>(Arrays.asList(product1,product2,product3,product4));

    ListView listViewProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        listViewProduct = findViewById(R.id.listViewProduct);
        ProductAdapter productAdapter = new ProductAdapter(Products);
        listViewProduct.setAdapter(productAdapter);

    }
}