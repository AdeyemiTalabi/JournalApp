package com.example.google.journal_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.google.journal_app.R;
import com.example.google.journal_app.helpers.InputValidation;
import com.example.google.journal_app.sql.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etEmail;

    private EditText etPassword;
    private EditText et_password_confirm;

    private Button buLogin;
    private Button buRegister;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        etPassword = (EditText) findViewById(R.id.etPassword);
        et_password_confirm = (EditText) findViewById(R.id.etPasswordConfirm);

        buLogin = (Button) findViewById(R.id.buLogin);
        buRegister = (Button) findViewById(R.id.buRegister);

    }


    public void clickRegister(View view) {
        Intent Intent = new Intent(this, RegisterSucceedActivity.class);
        startActivity(Intent);
    }

    public void clickLogin(View view) {
        Intent Intent = new Intent(this, LoginActivity.class);
        startActivity(Intent);
    }
}
