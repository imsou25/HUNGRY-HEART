package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hungryheart.hungryheart.R;

public class OrderActivity extends AppCompatActivity  implements View.OnClickListener{

    Dishes dishes;
    Button proceed;
    TextView food_ed,food_ed2;
    ImageView food_image;

    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            startActivity(new Intent(OrderActivity.this, HomeActivity.class));
        }

        Intent intent = getIntent();
        dishes = (Dishes) intent.getSerializableExtra("DISH");

        proceed=findViewById(R.id.proceed);
        proceed.setOnClickListener(this);

        food_ed=findViewById(R.id.food_ed);
        food_ed2=findViewById(R.id.food_ed2);

        food_image=findViewById(R.id.food_image);

        food_ed.setText(dishes.getfName());
        food_ed2.setText(dishes.getfPrice());
        food_image.setImageResource(dishes.getfImage());



    }

    @Override
    public void onClick(View view) {

        Intent intent =new Intent(OrderActivity.this,GamechangerActivity.class);
        startActivity(intent);

    }
}
