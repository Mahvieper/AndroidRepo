package com.example.myuserapplication.UserInterface.UI;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myuserapplication.R;

public class Authorization extends AppCompatActivity {
    public static final String TAG = "MyActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.authorization);
            Log.e(TAG, "In OnCreate");
        } catch (Exception e) {
            Log.e(TAG, "Authorization onCreate Method Called");
        }

    }

}
