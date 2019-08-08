package com.example.myuserapplication.UserInterface;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.UI.Authorization;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Splash extends AppCompatActivity {

    private static int splash_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splash.this, Authorization.class);
                    //Intent is used to switch from one activity to another.

                    startActivity(i);
                    //invoke the SecondActivity.

                    finish();
                    //the current activity will get finished.
                }
            }, splash_time);
        } catch (Exception e) {
            Log.e(TAG, "Splash onCreate Called");
        }
    }

}
