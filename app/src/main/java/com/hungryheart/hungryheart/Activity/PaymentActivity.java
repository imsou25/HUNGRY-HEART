package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.hungryheart.hungryheart.R;

public class PaymentActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    CheckBox CODCheckBox, paytmCheckBox;
   Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        order=findViewById(R.id.order);

        CODCheckBox = findViewById(R.id.CODCheckBox);
        paytmCheckBox = findViewById(R.id.paytmCheckBox);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PaymentActivity.this, "Your Order is Sucessfully Placed", Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(PaymentActivity.this,LastActivity.class);
                startActivity(intent);

                Toast.makeText(PaymentActivity.this, "Have a nice meal ", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String message = null;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
