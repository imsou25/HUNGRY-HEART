package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hungryheart.hungryheart.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button registration_button, login_button;
    TextView main_page, skipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        skipText = findViewById(R.id.text_skip);
        registration_button = findViewById(R.id.registration_button);
        login_button = findViewById(R.id.login_button);

        main_page = findViewById(R.id.main_page);

        skipText.setOnClickListener(this);
        registration_button.setOnClickListener(this);
        login_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.text_skip:
                finish();
                break;

            case R.id.registration_button:

                Intent intent = new Intent(HomeActivity.this, RegistrationActivity.class);
                startActivity(intent);
                break;
            case R.id.login_button:
                Intent intent1 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
