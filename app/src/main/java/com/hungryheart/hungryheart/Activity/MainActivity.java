package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hungryheart.hungryheart.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AdapterProduct adapterProduct;
    ArrayList<Product> list = new ArrayList<>();

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }

        generateData();

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        adapterProduct = new AdapterProduct(this, list);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProduct);
    }

    private void generateData() {
        Product product;

        product = new Product();
        product.setCatId(1);
        product.setfName("Indian");
        product.setfImage(R.drawable.indian);
        list.add(product);

        product = new Product();
        product.setCatId(2);
        product.setfName("Chinese");
        product.setfImage(R.drawable.chines);
        list.add(product);

        product = new Product();
        product.setCatId(3);
        product.setfName("Continental");
        product.setfImage(R.drawable.contentel);
        list.add(product);

        product = new Product();
        product.setCatId(4);
        product.setfName("Snacks");
        product.setfImage(R.drawable.snacks);
        list.add(product);

        product = new Product();
        product.setCatId(5);
        product.setfName("Drinks");
        product.setfImage(R.drawable.drinks);
        list.add(product);

        product = new Product();
        product.setCatId(6);
        product.setfName("Desserts");
        product.setfImage(R.drawable.desserts);
        list.add(product);

    }
}