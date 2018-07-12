package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hungryheart.hungryheart.R;

public class GamechangerActivity extends AppCompatActivity implements View.OnClickListener {
    Button yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamechanger);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.yes:
                Intent intent1 = new Intent(GamechangerActivity.this, DecorationActivity.class);
                startActivity(intent1);
                break;

            case R.id.no:
                Intent intent = new Intent(GamechangerActivity.this, PaymentActivity.class);
                startActivity(intent);
                break;

        }

    }
}
