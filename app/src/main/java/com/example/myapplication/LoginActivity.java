package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText user = findViewById(R.id.loginEmail);
        final EditText pass = findViewById(R.id.loginPassword);
        final Button loginButton = findViewById(R.id.loginButton);

        //temporary
        user.setText("admin");
        pass.setText("admin");

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                if (username.equals("admin") && password.equals("admin")) {
                    goToMenu();
                    Log.i("click", "logged");
                }
                else
                    Toast.makeText(getApplicationContext(), "Credentials aren't correct. Try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToMenu() {
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
    }
}