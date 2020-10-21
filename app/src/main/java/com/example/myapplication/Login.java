package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Login extends Fragment {
    FragmentManager loginManager = null;
    FragmentTransaction loginTransaction = null;
    public Login() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fLogin = inflater.inflate(R.layout.fragment_login, container, false);

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
}