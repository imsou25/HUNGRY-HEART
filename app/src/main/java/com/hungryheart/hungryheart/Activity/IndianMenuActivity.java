package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hungryheart.hungryheart.R;

import java.util.ArrayList;

public class IndianMenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AdapterIndian adapterindian;
    ArrayList<Dishes> filterList = new ArrayList<>();

    FirebaseUser user;


    String catName;
    int catId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_menu);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            startActivity(new Intent(IndianMenuActivity.this, HomeActivity.class));
        }

        Intent intent = getIntent();
        catId = intent.getIntExtra("CAT_ID", 1);
        catName = intent.getStringExtra("CAT_NAME");



        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        adapterindian = new AdapterIndian(this, filterList);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterindian);

        filterData(catId);
    }


    private void filterData(int id) {
        ArrayList<Dishes> list = generateData();
        for (int i = 0; i < list.size(); i++) {
            Dishes dishes = list.get(i);

            if (id == dishes.getCatId()) {
                filterList.add(dishes);
            }

        }
        adapterindian.setData(filterList);
    }

    private ArrayList<Dishes> generateData() {
        Dishes dishes;
        ArrayList<Dishes> list = new ArrayList<>();


        dishes = new Dishes();
        dishes.setCatId(1);
        dishes.setfName("Biryani");
        dishes.setfPrice("120");
        dishes.setfImage(R.drawable.biryani);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(1);
        dishes.setfName("Chicken Tikka Masala");
        dishes.setfPrice("180");
        dishes.setfImage(R.drawable.chicken_tikka_masala);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(1);
        dishes.setfName("Sahi Paneer");
        dishes.setfPrice("120");
        dishes.setfImage(R.drawable.sahi_paneer);
        list.add(dishes);


        dishes = new Dishes();
        dishes.setCatId(2);
        dishes.setfName("Momos");
        dishes.setfPrice("60");
        dishes.setfImage(R.drawable.momos);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(2);
        dishes.setfName("Noodles");
        dishes.setfPrice("50");
        dishes.setfImage(R.drawable.noodles);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(2);
        dishes.setfName("Susi");
        dishes.setfPrice("120");
        dishes.setfImage(R.drawable.susi);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(3);
        dishes.setfName("Taco");
        dishes.setfPrice("130");
        dishes.setfImage(R.drawable.taco);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(3);
        dishes.setfName("Roasted Chicken");
        dishes.setfPrice("220");
        dishes.setfImage(R.drawable.roastchicken);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(3);
        dishes.setfName("Pasta");
        dishes.setfPrice("150");
        dishes.setfImage(R.drawable.pasta);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(4);
        dishes.setfName("Samosa");
        dishes.setfPrice("20");
        dishes.setfImage(R.drawable.samosa);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(4);
        dishes.setfName("Egg Chop");
        dishes.setfPrice("15");
        dishes.setfImage(R.drawable.egg_chop);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(4);
        dishes.setfName("Khasta Kachori");
        dishes.setfPrice("60");
        dishes.setfImage(R.drawable.khasta_kachoro);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(5);
        dishes.setfName("Wine");
        dishes.setfPrice("350");
        dishes.setfImage(R.drawable.wine);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(5);
        dishes.setfName("Chilled Drinks");
        dishes.setfPrice("85");
        dishes.setfImage(R.drawable.soft_drink);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(5);
        dishes.setfName("Beer");
        dishes.setfPrice("150");
        dishes.setfImage(R.drawable.beer);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(6);
        dishes.setfName("Ice Cream");
        dishes.setfPrice("120");
        dishes.setfImage(R.drawable.ice_cream);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(6);
        dishes.setfName("Custard");
        dishes.setfPrice("120");
        dishes.setfImage(R.drawable.fruitcustard);
        list.add(dishes);

        dishes = new Dishes();
        dishes.setCatId(6);
        dishes.setfName("Choco Cake");
        dishes.setfPrice("120");
        dishes.setfImage(R.drawable.choco_cake);
        list.add(dishes);
        return list;

    }

}