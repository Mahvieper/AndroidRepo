package com.example.myuserapplication.UserInterface.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Shopping extends AppCompatActivity {

    public static List<Product> products=new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }
    private Toolbar mTopToolbar;
    private static final String TAG = "ShoppingActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.shopping_default);

            mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mTopToolbar);
/*

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavController navController= (NavController) Navigation.findNavController(Shopping.this,R.id.shopping_nav_host);
                    navController.navigate(R.id.action_shoppingFragment_to_cart_Items_Fragment);
                }
            });
*/

        }catch (Exception e) {
            Log.e(TAG,"In OnCreate of Shopping");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            NavController navController= (NavController) Navigation.findNavController(Shopping.this,R.id.shopping_nav_host);
            navController.navigate(R.id.action_shoppingFragment_to_cart_Items_Fragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
