package com.example.userapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        //Intializing Spinner
        Spinner state_spinner=(Spinner) findViewById(R.id.states_spinner);    //Spinner for Drop Down list of States.
        Spinner district_spinner=(Spinner) findViewById(R.id.district_spinner);
        Spinner gp_spinner=(Spinner) findViewById(R.id.grampanchayat_spinner);
        Spinner village_spinner=(Spinner) findViewById(R.id.village_spinner);

        ArrayAdapter<CharSequence> adapter_state=ArrayAdapter.createFromResource(this,R.array.india_states,android.R.layout.simple_spinner_item);
        adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state_spinner.setAdapter(adapter_state);

        ArrayAdapter<CharSequence> adapter_district=ArrayAdapter.createFromResource(this,R.array.india_districts,android.R.layout.simple_spinner_item);
        adapter_district.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district_spinner.setAdapter(adapter_district);

        ArrayAdapter<CharSequence> adapter_gp=ArrayAdapter.createFromResource(this,R.array.india_gp,android.R.layout.simple_spinner_item);
        adapter_gp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gp_spinner.setAdapter(adapter_gp);

        ArrayAdapter<CharSequence> adapter_village=ArrayAdapter.createFromResource(this,R.array.india_villages,android.R.layout.simple_spinner_item);
        adapter_village.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        village_spinner.setAdapter(adapter_village);



    }

}
