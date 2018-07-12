package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hungryheart.hungryheart.R;

public class DecorationActivity extends AppCompatActivity implements View.OnClickListener{
  Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);

        next=findViewById(R.id.next);

        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Thank you for choosing our Servises.", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(DecorationActivity.this,PaymentActivity.class);
        startActivity(intent);

    }
}
