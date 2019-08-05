package com.example.myuserapplication.UserInterface;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myuserapplication.R;

public class Authorization extends AppCompatActivity {
    public static final String TAG = "MyActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.authorization);
        Log.e(TAG,"In OnCreate");

        if (savedInstanceState == null) {
          /*  loadFragment(
                    R.id.container1,
                    new LoginFragment(),
                    LoginFragment.CLASSTAG,
                    false
            );*/


        }
    }

   /* public void loadFragment(
            int containerId,
            Fragment fragment,
            String classTag,
            boolean addToBackStack
    ) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (addToBackStack) {
                transaction.replace(containerId, fragment, classTag);
                transaction.addToBackStack(null);
            } else {
                transaction.replace(containerId, fragment);
            }
            transaction.commitAllowingStateLoss();
        } catch (Exception e) {
            Toast.makeText(this,"Not able to make Fragment",Toast.LENGTH_SHORT);
        }
    }*/
}
