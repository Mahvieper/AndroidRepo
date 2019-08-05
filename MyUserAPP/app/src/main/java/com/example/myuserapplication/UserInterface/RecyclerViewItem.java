/*
package com.example.myuserapplication.UserInterface;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Item;
import com.example.myuserapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewItem extends AppCompatActivity implements IValueEntered {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        RecyclerView itemsList=findViewById(R.id.recycleView);
        ItemAdapter itemAdapter=new ItemAdapter(this,getDummyItemsList());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        itemAdapter.setValueEnteredListner(this);
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(itemAdapter);

        itemAdapter.notifyDataSetChanged();
    }

    private List<Item> getDummyItemsList() {
        List<Item> itemList = new ArrayList<>();
        Item item;

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Mahesh Sharma");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Shridhar Gaikwad");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Apurva Shepal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Hemakant G");
        item.setSubTitle("React Dev");
        item.setImage(R.drawable.eye);
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Akshay Toshniwal");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        return itemList;

    }

    @Override
    public void onTitleClicked(String text) {
        Toast.makeText(this, "You have entered :" + text, Toast.LENGTH_SHORT).show();
    }
}
*/
