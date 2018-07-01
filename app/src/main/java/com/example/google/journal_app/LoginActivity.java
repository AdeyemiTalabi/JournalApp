package com.example.google.journal_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.google.journal_app.helpers.InputValidation;
import com.example.google.journal_app.sql.DatabaseHelper;


public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;

    private Button buLogin;
    private Button buRegister;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        buLogin = (Button) findViewById(R.id.buLogin);
        buRegister = (Button) findViewById(R.id.buRegister);

    }

    public void clickLogin(View view) {
        Intent Intent = new Intent(this, JournalDashboardActivity.class);
        startActivity(Intent);
    }

    public void clickRegister(View view) {
        Intent Intent = new Intent(this, RegisterActivity.class);
        startActivity(Intent);
    }

    public void clickGoogleLogin(View view) {
        Intent Intent = new Intent(this, GoogleAccountSignInActivity.class);
        startActivity(Intent);
    }
}