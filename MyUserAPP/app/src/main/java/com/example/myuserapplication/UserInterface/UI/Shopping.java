package com.example.myuserapplication.UserInterface.UI;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myuserapplication.R;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {

    private Toolbar mTopToolbar;
    private static final String TAG = "ShoppingActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.shopping_default);

            mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mTopToolbar);

        } catch (Exception e) {
            Log.e(TAG, "In OnCreate of Shopping");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar_items, menu);
        return true;
    }



}
