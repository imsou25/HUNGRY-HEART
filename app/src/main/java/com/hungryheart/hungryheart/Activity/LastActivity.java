package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hungryheart.hungryheart.R;

public class LastActivity extends AppCompatActivity  implements View.OnClickListener{
Button last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        last=findViewById(R.id.last);

        last.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent= new Intent(LastActivity.this,MainActivity.class);
        startActivity(intent);

    }
}
