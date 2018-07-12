package com.hungryheart.hungryheart.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SHARED_PREF_NAME = "Hungry_heart";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";


    FirebaseAuth auth;
    EditText name_reg, phone_reg, password_reg, email_reg;
    Button signin_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name_reg = findViewById(R.id.name);
        phone_reg = findViewById(R.id.phone);
        email_reg = findViewById(R.id.email);
        password_reg = findViewById(R.id.password);
        signin_button = findViewById(R.id.signin_button);

        auth = FirebaseAuth.getInstance();

        signin_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        register();

    }

    private void register() {

        String name = name_reg.getText().toString();
        String phone = phone_reg.getText().toString();
        String email = email_reg.getText().toString();
        String password = password_reg.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_PHONE, phone);

        editor.apply();
        name_reg.setText("");
        phone_reg.setText("");

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(RegistrationActivity.this, "You Are Sucessfully Registered", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(RegistrationActivity.this, "Details are invalid or you are registered with this details", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (name.isEmpty()) {
            name_reg.setError("Name required");
            name_reg.requestFocus();
            return;
        } else if (phone.isEmpty()) {
            phone_reg.setError("Phone no. required");
            phone_reg.requestFocus();
            return;
        } else if (email.isEmpty()) {
            email_reg.setError("Email required");
            email_reg.requestFocus();
            return;
        } else if (password.isEmpty()) {
            password_reg.setError("Password required");
            password_reg.requestFocus();
            return;
        }
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
        


    }

}
