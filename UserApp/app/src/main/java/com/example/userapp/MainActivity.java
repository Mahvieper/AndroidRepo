package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_phone=(EditText) findViewById(R.id.et_phone);


    }

    public void click(View view) {
        Intent i=new Intent(this,Registration.class);
        startActivity(i);
    }
}
