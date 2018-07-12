package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hungryheart.hungryheart.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    EditText email_log, password_log;
    Button login_button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        email_log = findViewById(R.id.email);
        password_log = findViewById(R.id.password);

        login_button1 = findViewById(R.id.login_button1);

        login_button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        login();

    }


    private void login() {
        String email = email_log.getText().toString();
        String password = password_log.getText().toString();

        if (email.isEmpty()) {
            email_log.setError("Email required");
            email_log.requestFocus();
            return;
        } else if (password.isEmpty()) {
            password_log.setError("Password required");
            password_log.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(LoginActivity.this, "Invalid Email Id or Password", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}

