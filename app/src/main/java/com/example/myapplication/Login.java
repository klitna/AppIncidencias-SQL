package com.example.myapplication;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.Toast;

public class Login extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        View fLogin = inflater.inflate(R.layout.fragment_login_old, container, false);

        final EditText user = fLogin.findViewById(R.id.loginEmail);
        final EditText pass = fLogin.findViewById(R.id.loginPassword);
        final Button loginButton = fLogin.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String User = user.getText().toString();
                String Password = pass.getText().toString();
                if (User.equals("admin") && Password.equals("admin")) {
                    goToMenu();
                    Log.i("click", "logged");
                }
            }
        });
        return fLogin;
    }

    public void goToMenu() {
        FragmentManager menuManager = getFragmentManager();
        FragmentTransaction menuTransaction = menuManager.beginTransaction();
        Fragment fListIncidences = new ListIncidences();
        menuTransaction.replace(R.id.constraintMainLayout, fListIncidences);
        menuTransaction.commit();
    }
}

/*
public class Login extends Fragment {
    FragmentManager loginManager;
    FragmentTransaction loginTransaction;

    public Login() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        // Inflate the layout for this fragment
        final View fLogin = inflater.inflate(R.layout.fragment_login, container, false);

        EditText user = fLogin.findViewById(R.id.loginEmail);
        EditText pass = fLogin.findViewById(R.id.loginPassword);
        user.setText("admin");
        pass.setText("admin");

        Button loginButton = fLogin.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("click", "button add clicked");
                loginManager = getFragmentManager();
                loginTransaction = loginManager.beginTransaction();
                Fragment fMenu = new Menu();
                loginTransaction.replace(R.id.constraintMainLayout, fMenu);
                loginTransaction.commit();
            }
        });
        return fLogin;
    }

    public void hideView(View fLogin){
        ViewGroup.LayoutParams params = fLogin.getLayoutParams();
        params.height = -1000;
        fLogin.requestLayout();
    }

    public void showeView(View fLogin){
        ViewGroup.LayoutParams params = fLogin.getLayoutParams();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        fLogin.requestLayout();
    }



        */