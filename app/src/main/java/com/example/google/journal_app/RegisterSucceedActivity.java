package com.example.google.journal_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterSucceedActivity extends AppCompatActivity {

    private TextView loginSucceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_succeed);

        loginSucceed = (TextView) findViewById(R.id.tvSucceed);
    }


    public void clickLogin(View view) {
        Intent Intent = new Intent(this, LoginActivity.class);
        startActivity(Intent);
    }
}
